package br.com.getup.testlogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author MarkusPatriota
 */
@Entity
@NamedQueries(value ={@NamedQuery(name="Usuario.findByNomeSenha",query="SELECT u "
        + "FROM usuario_tb u WHERE u.nome=:nome and u.senha=:senha")})
@Table(name="usuario_tb")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    
    @Transient
    private static final String FIND_BY_NOME_SENHA="Usuario.findByNomeSenha";
    
    @Column
    private String name;
    
    @Column
    private String senha;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Long getID() {
        return ID;
    }
    
    public void setID(Long ID) {
        this.ID = ID;
    }
    
}
