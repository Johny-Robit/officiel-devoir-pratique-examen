package ca.ulaval.glo4002.pratique.infrastructure.persistence.memoire;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.jvnet.hk2.annotations.Service;

import ca.ulaval.glo4002.pratique.domaine.etablissement.EtablissementNonTrouveException;
import ca.ulaval.glo4002.pratique.domaine.etablissement.EtablissementStockage;
import ca.ulaval.glo4002.pratique.domaine.etablissement.numero.NoEtablissement;
import ca.ulaval.glo4002.pratique.domaine.etablissement.Etablissement;

@Service
public class EtablissementStockageEnMemoire implements EtablissementStockage {
    private static final Map<NoEtablissement, Etablissement> stockage = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Etablissement trouverEtablissement(NoEtablissement noEtablissement) {
        var etablissement = stockage.get(noEtablissement);
        if (etablissement == null) {
            throw new EtablissementNonTrouveException(noEtablissement);
        }

        return etablissement;
    }

    public void ajouterEtablissement(Etablissement etablissement) {
        stockage.put(etablissement.getNumero(), etablissement);
    }
}
