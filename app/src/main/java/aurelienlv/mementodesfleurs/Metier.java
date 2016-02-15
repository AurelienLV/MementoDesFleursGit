package aurelienlv.mementodesfleurs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Vector;

/**
 * Created by Aurélien on 11/10/2015.
 */
public class Metier {

    private static Metier instance;
    private Vector<Fleur> fleurs;
    private Vector<Fleur> fleursFaites;
    private Vector<Fleur> fleursNonFaites;

    public static Metier getInstance() {
        if (null == instance) {
            instance = new Metier();
        }
        return instance;
    }

    private Metier() {
        fleurs = new Vector<Fleur>();
        fleursFaites = new Vector<Fleur>();
        fleursNonFaites = new Vector<Fleur>();
        creerFleurs();
    }

    public void creerFleurs() {
        fleurs.addElement(new Fleur("Anthurium","Anthurium",EnumFleurs.Aracées, R.drawable.img1));
        fleurs.addElement(new Fleur("Arum/Calla","Zantedeschia",EnumFleurs.Aracées, R.drawable.img2));
        fleurs.addElement(new Fleur("Philodendron Monstera", "Monstera", EnumFleurs.Aracées, R.drawable.img3));
        fleurs.addElement(new Fleur("Dieffenbachia", "Dieffenbachia", EnumFleurs.Aracées, R.drawable.img4));
        fleurs.addElement(new Fleur("Philos","Philodendron", EnumFleurs.Aracées, R.drawable.img5));
        fleurs.addElement(new Fleur("Spathiphyllum", "Spathiphyllum", EnumFleurs.Aracées, R.drawable.img6));
        fleurs.addElement(new Fleur("Amarante", "Amaranthus", EnumFleurs.Amaranthacées, R.drawable.img7));
        fleurs.addElement(new Fleur("Celosie", "Celosia", EnumFleurs.Amaranthacées, R.drawable.img8));
        fleurs.addElement(new Fleur("Laurier rose", "Nerium oleander", EnumFleurs.Apocynacées, R.drawable.img9));
        fleurs.addElement(new Fleur("Jasmin de Madagascar", "Stephanotis", EnumFleurs.Apocynacées, R.drawable.img10));
        fleurs.addElement(new Fleur("Papyrus","Cyperus", EnumFleurs.Cyperacées, R.drawable.img11));
        fleurs.addElement(new Fleur("Violette du cap", "Saintpaulia", EnumFleurs.Gesneriacées, R.drawable.img12));
        fleurs.addElement(new Fleur("Columnea", "Columnea", EnumFleurs.Gesneriacées, R.drawable.img13));
        fleurs.addElement(new Fleur("Oreilles d'éléphant","Streptocarpus",EnumFleurs.Gesneriacées, R.drawable.img14));
        fleurs.addElement(new Fleur("Gloxinia des fleuristes", "Sinningia", EnumFleurs.Gesneriacées, R.drawable.img15));
        fleurs.addElement(new Fleur("Bouvardia", "Bouvardia", EnumFleurs.Rubiacées, R.drawable.img16));
        fleurs.addElement(new Fleur("Jasmin du cap", "Gardenia", EnumFleurs.Rubiacées, R.drawable.img17));
        fleurs.addElement(new Fleur("Begonia", "Begonia", EnumFleurs.Begoniacées, R.drawable.img18));
        fleurs.addElement(new Fleur("Buis commun", "Buxus", EnumFleurs.Buxacées, R.drawable.img19));
        fleurs.addElement(new Fleur("Amaryllis", "Hippeastrum", EnumFleurs.Amaryllidacées, R.drawable.img20));
        fleurs.addElement(new Fleur("Narcisse", "Narcissus", EnumFleurs.Amaryllidacées, R.drawable.img21));
        fleurs.addElement(new Fleur("Clivia", "Clivia miniata", EnumFleurs.Amaryllidacées, R.drawable.img22));
        fleurs.addElement(new Fleur("Nerine", "Nerine", EnumFleurs.Amaryllidacées, R.drawable.img23));
        fleurs.addElement(new Fleur("Primevère", "Primula", EnumFleurs.Primulacées, R.drawable.img24));
        fleurs.addElement(new Fleur("Cyclamen", "Cyclamen", EnumFleurs.Primulacées, R.drawable.img25));
        fleurs.addElement(new Fleur("Pommier d'amour", "Solanum", EnumFleurs.Solanacées, R.drawable.img26));
        fleurs.addElement(new Fleur("Amour en cage", "Physalis", EnumFleurs.Solanacées, R.drawable.img27));
        fleurs.addElement(new Fleur("Browallie", "Browallia", EnumFleurs.Solanacées, R.drawable.img28));
        fleurs.addElement(new Fleur("Scabieuse", "Scabiosa", EnumFleurs.Dipsacacées, R.drawable.img29));
        fleurs.addElement(new Fleur("Plante zèbre", "Aphelandra", EnumFleurs.Acanthacées, R.drawable.img30));
        fleurs.addElement(new Fleur("Ananas", "Ananas", EnumFleurs.Broméliacées, R.drawable.img31));
        fleurs.addElement(new Fleur("Billbergia", "Aechmea fasciata", EnumFleurs.Broméliacées, R.drawable.img32));
        fleurs.addElement(new Fleur("Vriesea", "Vriesea", EnumFleurs.Broméliacées, R.drawable.img33));
        fleurs.addElement(new Fleur("Chamaerops", "Chamaerops", EnumFleurs.Arécacées, R.drawable.img34));
        fleurs.addElement(new Fleur("Palmier nain", "Chamaedorea", EnumFleurs.Arécacées, R.drawable.img35));
        fleurs.addElement(new Fleur("Cocotier", "Cocos nucifera", EnumFleurs.Arécacées, R.drawable.img36));
        fleurs.addElement(new Fleur("Palmier des Canaries", "Phoenix", EnumFleurs.Arécacées, R.drawable.img37));
        fleurs.addElement(new Fleur("Dame peinte", "Echeveria", EnumFleurs.Crassulacées, R.drawable.img38));
        fleurs.addElement(new Fleur("Kalanchoe", "Kalanchoe", EnumFleurs.Crassulacées, R.drawable.img39));
        fleurs.addElement(new Fleur("Orpin", "Sedum", EnumFleurs.Crassulacées, R.drawable.img40));
        fleurs.addElement(new Fleur("Joubarbe", "Sempervivum", EnumFleurs.Crassulacées, R.drawable.img41));
        fleurs.addElement(new Fleur("Alstroemere","Alstroemeria", EnumFleurs.Alstroemeriacées, R.drawable.img42));
        fleurs.addElement(new Fleur("Oiseau de paradis", "Strelitzia", EnumFleurs.Musacées, R.drawable.img43));
        fleurs.addElement(new Fleur("Heliconia", "Heliconia", EnumFleurs.Musacées, R.drawable.img44));
        fleurs.addElement(new Fleur("Faux cyprès", "Chamaecyparis", EnumFleurs.Cupressacées, R.drawable.img45));
        fleurs.addElement(new Fleur("Thuya", "Thuja", EnumFleurs.Cupressacées, R.drawable.img46));
        fleurs.addElement(new Fleur("Hêtre", "Fagus", EnumFleurs.Fagacées, R.drawable.img47));
        fleurs.addElement(new Fleur("Chêne", "Quercus", EnumFleurs.Fagacées, R.drawable.img48));
        fleurs.addElement(new Fleur("Vigne d'appartement", "Cissus", EnumFleurs.Vitacées, R.drawable.img49));
        fleurs.addElement(new Fleur("Asperge d'ornement", "Asparagus", EnumFleurs.Asparagacées, R.drawable.img50));
        fleurs.addElement(new Fleur("Ail d'ornement", "Allium", EnumFleurs.Alliacées, R.drawable.img51));
        fleurs.addElement(new Fleur("Agapanthe", "Agapanthus", EnumFleurs.Alliacées, R.drawable.img52));
        fleurs.addElement(new Fleur("Mahonia feuilles de houx", "Mahonia x", EnumFleurs.Berbéridacées, R.drawable.img53));
        fleurs.addElement(new Fleur("Aloe", "Aloe", EnumFleurs.Asphodélacées, R.drawable.img54));
        fleurs.addElement(new Fleur("Lis des steppes", "Eremurus", EnumFleurs.Asphodélacées, R.drawable.img55));
        fleurs.addElement(new Fleur("Hibiscus", "Hibiscus", EnumFleurs.Malvacées, R.drawable.img56));
        fleurs.addElement(new Fleur("Cordyline", "Cordyline", EnumFleurs.Asteliacées, R.drawable.img57));
        fleurs.addElement(new Fleur("Agave", "Agave", EnumFleurs.Agavacées, R.drawable.img58));
        fleurs.addElement(new Fleur("Plante aluminium", "Pilea", EnumFleurs.Urticacées, R.drawable.img59));
        fleurs.addElement(new Fleur("Clerodendron", "Clerodendrum", EnumFleurs.Verbénacées, R.drawable.img60));
        fleurs.addElement(new Fleur("Mimosa", "Acacia", EnumFleurs.Fabacées, R.drawable.img61));
        fleurs.addElement(new Fleur("Pois de senteur", "Lathyrus", EnumFleurs.Fabacées, R.drawable.img62));
        fleurs.addElement(new Fleur("Pivoine", "Paeonia", EnumFleurs.Paeoniacées, R.drawable.img63));
        fleurs.addElement(new Fleur("Corne d'élan", "Platycerium", EnumFleurs.Polypodiacées, R.drawable.img64));
        fleurs.addElement(new Fleur("Pellaea", "Pellaea", EnumFleurs.Polypodiacées, R.drawable.img65));
        fleurs.addElement(new Fleur("Capillaire", "Adiantum", EnumFleurs.Polypodiacées, R.drawable.img66));
        fleurs.addElement(new Fleur("Nephrolepis", "Nephrolepis", EnumFleurs.Polypodiacées, R.drawable.img67));
        fleurs.addElement(new Fleur("Fougère nid d'oiseau", "Asplenium", EnumFleurs.Polypodiacées, R.drawable.img68));
        fleurs.addElement(new Fleur("Pteris", "Pteris", EnumFleurs.Polypodiacées, R.drawable.img69));
        fleurs.addElement(new Fleur("Fougère US", "Arachniodes", EnumFleurs.Polypodiacées, R.drawable.img70));
        fleurs.addElement(new Fleur("Fuchsia", "Fuchsia x", EnumFleurs.Onagracées, R.drawable.img71));
        fleurs.addElement(new Fleur("Impatiens", "Impatiens x", EnumFleurs.Balsaminacées, R.drawable.img72));
        fleurs.addElement(new Fleur("Campanule", "Campanula", EnumFleurs.Campanulacées, R.drawable.img73));
        fleurs.addElement(new Fleur("Lis", "Lilium", EnumFleurs.Liliacées, R.drawable.img74));
        fleurs.addElement(new Fleur("Tulipe", "Tulipa", EnumFleurs.Liliacées, R.drawable.img75));
        fleurs.addElement(new Fleur("Lis de malabar", "Gloriosa", EnumFleurs.Colchicacées, R.drawable.img76));
        fleurs.addElement(new Fleur("Muguet", "Convallaria majalis", EnumFleurs.Convallariacées, R.drawable.img77));
        fleurs.addElement(new Fleur("Sansevière", "Sansevieria", EnumFleurs.Convallariacées, R.drawable.img78));
        fleurs.addElement(new Fleur("Ruscus", "Ruscus", EnumFleurs.Convallariacées, R.drawable.img79));
        fleurs.addElement(new Fleur("Aspidistra", "Aspidistra", EnumFleurs.Convallariacées, R.drawable.img80));
        fleurs.addElement(new Fleur("Dragonnier", "Dracaena", EnumFleurs.Convallariacées, R.drawable.img81));
        fleurs.addElement(new Fleur("Jacynthe", "Hyacinthus", EnumFleurs.Hyacinthacées, R.drawable.img82));
        fleurs.addElement(new Fleur("Muscari", "Muscari", EnumFleurs.Hyacinthacées, R.drawable.img83));
        fleurs.addElement(new Fleur("Scille", "Scilla", EnumFleurs.Hyacinthacées, R.drawable.img84));
        fleurs.addElement(new Fleur("Ornithogale", "Ornithogalum", EnumFleurs.Hyacinthacées, R.drawable.img85));
        fleurs.addElement(new Fleur("Lisianthus", "Eustoma", EnumFleurs.Gentianacées, R.drawable.img86));
        fleurs.addElement(new Fleur("Euphorbe", "Euphorbia fulgens", EnumFleurs.Euphorbiacées, R.drawable.img87));
        fleurs.addElement(new Fleur("Epine du Christ", "Euphorbia splendens", EnumFleurs.Euphorbiacées, R.drawable.img88));
        fleurs.addElement(new Fleur("Poinsettia", "Euphorbia pulcherrima", EnumFleurs.Euphorbiacées, R.drawable.img89));
        fleurs.addElement(new Fleur("Croton", "Codiaeum", EnumFleurs.Euphorbiacées, R.drawable.img90));
        fleurs.addElement(new Fleur("Géranium", "Pelargonium", EnumFleurs.Géraniacées, R.drawable.img91));
        fleurs.addElement(new Fleur("Misère", "Tradescantia", EnumFleurs.Commelinacées, R.drawable.img92));
        fleurs.addElement(new Fleur("Maranta", "Maranta", EnumFleurs.Marantacées, R.drawable.img93));
        fleurs.addElement(new Fleur("Ctenanthe", "Ctenanthe", EnumFleurs.Marantacées, R.drawable.img94));
        fleurs.addElement(new Fleur("Iris", "Iris", EnumFleurs.Iridacées, R.drawable.img95));
        fleurs.addElement(new Fleur("Ixia", "Ixia", EnumFleurs.Iridacées, R.drawable.img96));
        fleurs.addElement(new Fleur("Crocosmia", "Crocosmia", EnumFleurs.Iridacées, R.drawable.img97));
        fleurs.addElement(new Fleur("Crocus", "Crocus", EnumFleurs.Iridacées, R.drawable.img98));
        fleurs.addElement(new Fleur("Freesia", "Freesia", EnumFleurs.Iridacées, R.drawable.img99));
        fleurs.addElement(new Fleur("Glaïeul", "Gladiolus", EnumFleurs.Iridacées, R.drawable.img100));
        fleurs.addElement(new Fleur("Bougainvillée", "Bougainvillea", EnumFleurs.Nyctaginacées, R.drawable.img101));
        fleurs.addElement(new Fleur("Camélia", "Camelia", EnumFleurs.Theacées, R.drawable.img102));
        fleurs.addElement(new Fleur("Bruyère", "Erica", EnumFleurs.Ericacées, R.drawable.img103));
        fleurs.addElement(new Fleur("Azalée", "Rhododendron", EnumFleurs.Ericacées, R.drawable.img104));
        fleurs.addElement(new Fleur("Lilas", "Syringa", EnumFleurs.Oleacées, R.drawable.img105));
        fleurs.addElement(new Fleur("Forsythia", "Forsythia x", EnumFleurs.Oleacées, R.drawable.img106));
        fleurs.addElement(new Fleur("Rose", "Rosa", EnumFleurs.Rosacées, R.drawable.img107));
        fleurs.addElement(new Fleur("Laurier cerise", "Prunus laurocerasus", EnumFleurs.Rosacées, R.drawable.img108));
        fleurs.addElement(new Fleur("Muflier", "Antirrhinum", EnumFleurs.Scrophulariacées, R.drawable.img109));
        fleurs.addElement(new Fleur("Calceolaire", "Calceolaria", EnumFleurs.Scrophulariacées, R.drawable.img110));
        fleurs.addElement(new Fleur("Véronique", "Veronica", EnumFleurs.Scrophulariacées, R.drawable.img111));
        fleurs.addElement(new Fleur("Giroflée", "Matthiola", EnumFleurs.Brassicacées, R.drawable.img112));
        fleurs.addElement(new Fleur("Phlox", "Phlox", EnumFleurs.Polemoniacées, R.drawable.img113));
        fleurs.addElement(new Fleur("Hortensia", "Hydrangea macrophylla", EnumFleurs.Hydrangeacées, R.drawable.img114));
        fleurs.addElement(new Fleur("Lierre", "Hedera", EnumFleurs.Araliacées, R.drawable.img115));
        fleurs.addElement(new Fleur("Fatshedera", "Fatshedera", EnumFleurs.Araliacées, R.drawable.img116));
        fleurs.addElement(new Fleur("Aralia", "Fatsia japonica", EnumFleurs.Araliacées, R.drawable.img117));
        fleurs.addElement(new Fleur("Schefflera", "Schefflera", EnumFleurs.Araliacées, R.drawable.img118));
        fleurs.addElement(new Fleur("Oeillet", "Dianthus", EnumFleurs.Caryophyllacées, R.drawable.img119));
        fleurs.addElement(new Fleur("Gypsophille", "Gypsophylla", EnumFleurs.Caryophyllacées, R.drawable.img120));
        fleurs.addElement(new Fleur("Grevilléa", "Grevilléa", EnumFleurs.Proteacées, R.drawable.img121));
        fleurs.addElement(new Fleur("Statice", "Limonium", EnumFleurs.Plumbaginacées, R.drawable.img122));
        fleurs.addElement(new Fleur("Boule de neige", "Viburnum opulus", EnumFleurs.Caprifoliacées, R.drawable.img123));
        fleurs.addElement(new Fleur("Violette", "Viola", EnumFleurs.Violacées, R.drawable.img124));
        fleurs.addElement(new Fleur("Renoncule", "Ranunculus", EnumFleurs.Renonculacées, R.drawable.img125));
        fleurs.addElement(new Fleur("Rose de Noël", "Hellebrus Niger", EnumFleurs.Renonculacées, R.drawable.img126));
        fleurs.addElement(new Fleur("Aconite", "Aconitum", EnumFleurs.Renonculacées, R.drawable.img127));
        fleurs.addElement(new Fleur("Pied d'alouette", "Delphinium", EnumFleurs.Renonculacées, R.drawable.img128));
        //fleurs.addElement(new Fleur("Cattleya", "Cattleya", EnumFleurs.Orchidacées, R.drawable.img129));
        //fleurs.addElement(new Fleur("Oncidium", "Oncidium", EnumFleurs.Orchidacées, R.drawable.img130));
        //fleurs.addElement(new Fleur("Sabot de Vénus", "Paphiopedilum", EnumFleurs.Orchidacées, R.drawable.img131));
        //fleurs.addElement(new Fleur("Odontoglossum", "Odontoglossum", EnumFleurs.Orchidacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Cymbidium", "Cymbidium", EnumFleurs.Orchidacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Dendrobium", "Dendrobium", EnumFleurs.Orchidacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Phalaenopsis", "Phalaenopsis", EnumFleurs.Orchidacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Orchidée araignée", "Arachnis", EnumFleurs.Orchidacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Houx", "Ilex", EnumFleurs.Aquifoliacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Eucalyptus", "Eucalyptus", EnumFleurs.Myrtacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Astilbe", "Astilbe", EnumFleurs.Saxifragacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Molucelle", "Molucella", EnumFleurs.Lamiacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Ficus", "Ficus", EnumFleurs.Moracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Apténia", "Mesembryanthémum", EnumFleurs.Aizoacées, R.drawable.img));
        //fleurs.addElement(new Fleur("Aster", "Aster", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Achillée", "Achillea", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Souci", "Calendula officinalis", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Reine marguerite", "Callistephus Chinensis", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Bleuet", "Centaunea", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Chrysanthème", "Chrysanthemum", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Gaillarde", "Gaillardia", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Gerbera", "Gerbera", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Tournesol", "Helianthus", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Immortelle", "Helichrysum", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Rudbeckia", "Rudbeckia", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Rose d'Inde", "Tagetes erecta", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Zillia", "Zillia", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Liatris", "Liatris", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Pâquerette", "Bellis perennis", EnumFleurs.Asteracées, R.drawable.img));
        //fleurs.addElement(new Fleur("Cinéraire", "Cinéraria", EnumFleurs.Asteracées, R.drawable.img));
    }

    public Vector<Fleur> getFleurs() {
        return fleurs;
    }

    public Vector<Fleur> getFleursNonFaites() {
        return fleursNonFaites;
    }

    public Vector<Fleur> getFleursFaites() {
        return fleursFaites;
    }

    public void reinitFleurs() {
        fleursNonFaites.removeAllElements();
        fleursNonFaites.addAll(fleurs);
        fleursFaites.removeAllElements();
    }
}
