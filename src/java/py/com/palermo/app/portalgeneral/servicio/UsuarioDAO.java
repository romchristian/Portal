/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.servicio;

import py.com.palermo.app.portalgeneral.servicio.util.QueryParameter;
import py.com.palermo.app.portalgeneral.servicio.util.ABMService;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.palermo.app.portalgeneral.modelo.Usuario;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSearchException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UsuarioDAO extends AbstractDAO<Usuario> {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Usuario create(Usuario entity) {
        return abmService.create(entity);
    }

    @Override
    public Usuario edit(Usuario entity) {
        return abmService.update(entity);
    }

    @Override
    public void remove(Usuario entity) {
        abmService.delete(entity);
    }

    @Override
    public Usuario find(Object id) {
        return abmService.find(id, Usuario.class);
    }

    @Override
    public List<Usuario> findAll() {
        return abmService.getEM().createQuery("select obj from Usuario obj").getResultList();
    }

    @Override
    public List<Usuario> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    public Usuario find(String username, String correo) {
        Usuario R = null;
        try {
            R = (Usuario) abmService.getEM().createQuery("SELECT u FROM Usuario u WHERE u.username = :user")
                    .setParameter("user", username)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return R;
    }

    public Usuario getUsuario(String deviceId) {
        Usuario R = null;
        try {
            R = (Usuario) abmService.getEM().createQuery("SELECT u FROM Usuario u WHERE u.pdvMovil.deviceid = :deviceId")
                    .setParameter("deviceId", deviceId)
                    .getSingleResult();
        } catch (Exception e) {

        }
        return R;
    }

    public void migrar() throws LDAPException {

        LDAPConnection conn = getConnection();
        List<SearchResultEntry> lista = getResults(conn, "cn=Users,dc=palermo,dc=com,dc=py", "(&(objectClass=User)(Department=*)(!(userAccountControl:1.2.840.113556.1.4.803:=2)))");

        for (SearchResultEntry e : lista) {
            String username = e.getAttribute("sAMAccountName").getValue();

            Usuario u = find(username, "");
            if (u == null) {
                u = new Usuario();
                u.setNombre(e.getAttributeValue("displayName") != null ? e.getAttribute("displayName").getValue() : "No definido");
                u.setUsername(e.getAttributeValue("sAMAccountName") != null ? e.getAttribute("sAMAccountName").getValue() : "No definido");
                u.setEmail(e.getAttributeValue("mail") != null ? e.getAttribute("mail").getValue() : "No definido");
                abmService.getEM().merge(u);
            }
        }

    }

    public LDAPConnection getConnection() throws com.unboundid.ldap.sdk.LDAPException {
        return new LDAPConnection("172.16.10.2", 389, "ldapQuery@palermo.com.py", "ldapQuery123");
    }

    public List<SearchResultEntry> getResults(LDAPConnection connection, String baseDN, String filter) throws LDAPSearchException {
        SearchResult searchResult;

        if (connection.isConnected()) {
            searchResult = connection.search(baseDN, SearchScope.ONE, filter);
            return searchResult.getSearchEntries();
        }

        return null;
    }

}
