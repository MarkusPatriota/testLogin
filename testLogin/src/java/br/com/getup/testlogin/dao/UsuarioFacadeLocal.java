package br.com.getup.testlogin.dao;

import br.com.getup.testlogin.model.Usuario;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.Query;

/**
 *
 * @author MarkusPatriota
 */
@Local
public interface UsuarioFacadeLocal {
    
    public void create(Usuario usuario);
    
    public void edit(Usuario usuario);
    
    public void remove(Usuario usuario);
    
    public Usuario find(Object id);
    
    public List<Usuario> findAll();
    
    public List<Usuario> findRange(int[] range);
    
    public int count();
    
    public boolean findNameBySenha(String nome,String senha);
    
}
