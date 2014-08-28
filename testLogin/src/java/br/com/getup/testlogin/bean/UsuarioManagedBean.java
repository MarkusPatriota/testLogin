package br.com.getup.testlogin.bean;

import br.com.getup.testlogin.dao.UsuarioFacadeLocal;
import br.com.getup.testlogin.model.Usuario;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author MarkusPatriota
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean implements UsuarioBeanIF{

     @Inject
     private UsuarioFacadeLocal usuarioFacadeLocal;
     private Usuario usuario;
    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
    }

    @Override
    public Usuario isUsuario(String nome, String senha) {

        try {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Verificando usuario", ""));
            List retorno= usuarioFacadeLocal.findNameBySenha("SELECT u "
                    + "FROM usuario_tb u WHERE u.name=:name and u.senha=:senha")
                    .setParameter("name", usuario.getName())
                    .setParameter("senha", usuario.getSenha()).getResultList();
            
        } catch (Exception e) {
        }
        return null;
    }
      
    
    
}
