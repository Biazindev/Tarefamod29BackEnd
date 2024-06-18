package br.com.tbiazin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.tbiazin.dao.ProdutoDAO;
import br.com.tbiazin.domain.Produto;

public class ProdutoTeste {

    private ProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        
        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Rodrigo Pires");
        
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);
        
        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        
        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }
    
    @Test
    public void buscarTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        
        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("peruca rodrigo");
        
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);
        
        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        
        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }
    
    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        
        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("peruca rodrigo");
        
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);
        
        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        
        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }
    
    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        
        Produto produto1 = new Produto();
        produto1.setCodigo("10");
        produto1.setNome("Rodrigo Pires");
        
        Integer countCad1 = produtoDAO.cadastrar(produto1);
        assertTrue(countCad1 == 1);
        
        Produto produto2 = new Produto();
        produto2.setCodigo("20");
        produto2.setNome("Teste");
        
        Integer countCad2 = produtoDAO.cadastrar(produto2);
        assertTrue(countCad2 == 1);
        
        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
        
        int countDel = 0;
        for (Produto pro : list) {
            produtoDAO.excluir(pro);
            countDel++;
        }
        assertEquals(list.size(), countDel);
        
        list = produtoDAO.buscarTodos();
        assertEquals(0, list.size());
    }
    
    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();
        
        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Rodrigo Pires");
        
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);
        
        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        
        produtoBD.setCodigo("20");
        produtoBD.setNome("Outro nome");
        
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);
        
        Produto produtoBD1 = produtoDAO.buscar("10");
        assertNull(produtoBD1);
        
        Produto produtoBD2 = produtoDAO.buscar("20");
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());
        
        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto pro : list) {
            produtoDAO.excluir(pro);
        }
    }
}
