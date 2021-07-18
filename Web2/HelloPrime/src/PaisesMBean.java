import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
* Managed Bean para autocompletar países.
*/
@ManagedBean
@SessionScoped
public class PaisesMBean {

    private String pais;

    /**
     * Método para 
     * @param pais
     * @return
     */
    public List<String> completar(String pais) {
        List<String> resultado = new ArrayList<String>();

        List<String> paises = new ArrayList<String>();
        paises.add("BRASIL");
        paises.add("ESTADOS UNIDOS");
        paises.add("ALEMANHA");
        paises.add("ARGENTINA");

        for (String p : paises) {
            if(p.startsWith(pais.toUpperCase()))
                resultado.add(p);
        }
        return resultado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}