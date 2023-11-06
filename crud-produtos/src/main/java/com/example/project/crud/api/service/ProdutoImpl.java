package com.example.project.crud.api.service;

import com.example.project.crud.api.component.ProdutoComponent;
import com.example.project.crud.api.config.MapperConfig;
import com.example.project.crud.api.constants.StatusProduto;
import com.example.project.crud.api.core.ProdutoService;
import com.example.project.crud.api.entity.ProdutoEntity;
import com.example.project.crud.api.exceptions.EntidadeException;
import com.example.project.crud.api.exceptions.ProdutoException;
import com.example.project.crud.api.record.ProdutoDto;
import com.example.project.crud.api.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.Optional;

@Transactional
@Service
public class ProdutoImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ProdutoComponent component;
    @Autowired
    MapperConfig mapper;

    @Override
    public Page<ProdutoDto> getProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable)
                .map(p -> mapper.MapperUtils().map(p, ProdutoDto.class));
    }

    @Override
    public Optional<ProdutoDto> criarProduto(ProdutoDto produtoDto) {
        try {
            if (ObjectUtils.isEmpty(produtoDto.getStatusProduto()) || produtoDto.getStatusProduto().equals(StatusProduto.CANCELADO)) {
                throw new ProdutoException("O produto está listado como CANCELADO.");
            }
            return getMapperDto(produtoDto);
        } catch (ProdutoException e) {
            throw new ProdutoException(e.getMessage());
        }
    }

    @Override
    public Optional<ProdutoDto> getProdutoId(Long id) {
        ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(() -> new EntidadeException(String.format("Produto não encontrado com o ID: "
                .concat(id.toString()))));
        return Optional.ofNullable(mapper.MapperUtils().map(produto, ProdutoDto.class));
    }

    @Override
    public Optional<ProdutoDto> atualizarProduto(Long id, ProdutoDto produtoDto) {
        try {
            Optional<ProdutoEntity> p = produtoRepository.findById(id);
            if(p.isPresent()) {
                return getMapperDto(produtoDto);
            }
            return Optional.empty();
        } catch (ProdutoException e) {
            throw new ProdutoException("Erro ao atualizar produto.");
        }
    }

    @Override
    public void produtoIdDeletado(Long id) {
        try {
            if (produtoRepository.existsById(id)) {
                produtoRepository.deleteById(id);
            }
        } catch (EntidadeException e) {
            throw new EntidadeException(e.getMessage());
        }
    }

    @Override
    public void deletarTodos() {
        produtoRepository.deleteAll();
    }

    private Optional<ProdutoDto> getMapperDto(ProdutoDto produtoDto) {
        ProdutoEntity produto = component.getProdutoEntity(produtoDto);
        produto = produtoRepository.save(produto);
        return Optional.ofNullable(mapper.MapperUtils().map(produto, ProdutoDto.class));
    }
}
