package ca.ulaval.glo4002.pratique.domaine.etablissement;

import ca.ulaval.glo4002.pratique.domaine.etablissement.numero.NoEtablissement;

public interface EtablissementStockage {
    Etablissement trouverEtablissement(NoEtablissement noEtablissement);
}
