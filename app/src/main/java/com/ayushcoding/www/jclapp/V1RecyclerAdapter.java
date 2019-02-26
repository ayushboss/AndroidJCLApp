package com.ayushcoding.www.jclapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by akhil on 7/9/16.
 */
public class V1RecyclerAdapter extends  RecyclerView.Adapter<V1RecyclerViewHolder> {


    String[] title = {"Iconography", "Lead Android Developer", "Lead IOS Developer", "Study Guide Help"};
    String[]sub = {"icons8.com", "Ayush Suresh", "Akhil Mandalapu", "FJCL and Ketan Ramakrishna"};
    String[] dataS = {"ambulo,anbulare,ambulavi,ambulatus", "amo,amare,amavi,amatus", "appropinquo, appropinquare, appropinquavi, appropinquatus", "clamo, clamare, clamavi, clamatus", "curo, curare, curavi, curatus", "demonstro, demonstrare, demonstravi, demonstratus", "do,dare,dedi,datus", "dono,donare,donavi,donatus", "festino, festinare, festinavi, festinatus", "habito, habitare, habitavi, habitatus", " incito, incitare, incitavi, incitatus", "intro, intrare, intravi, intratus", "laboro, laborare, laboravi, laboratus", "laudo, laudare, laudavi, laudatus", "libero, liberare, liberavi, liberatus", "navigo, navigare, navigavi, navigatus ", " nuntio, nuntiare, nuntiavi, nuntiatus", "paro, parare, paravi, paratus", "porto, portare, portavi, portatus", "pugno, pugnare, pugnavi, pugnatu", "rogo, rogare, rogavi, rogatus", "servo, servare, servavi, servatus", "specto,spectare,spectavi,spectatus", "sto, stare, steti, status", "vito, vitare, vitavi, vitatus", "voco, vocare, vocavi, vocatus", "vulnero, vulnerare, vulneravi, vulneratus", "appareo,apparēre,apparui, appariturus", "augeo, augēre, auxi, actus", "debeo, debēre, debui, debitus", "doceo, docēre, docui, doctus", "habeo, habēre, habui, habitus", "maneo, manēre, mansi, mansurus", "moneo, monēre, monui, monitus", "moveo, movēre, movi, motus", "rideo, ridēre, risi, risus", "teno, tenēre, tenui, tentus", "terreo, terrēre, terrui, territus", "timeo, timēre, timui", "video, vidēre, vidi, visus", "ago, agere, egi, actus", "amitto, amittere, amisi, amissus", "cado, cadere, cecidi, casus", "cedo, cedere, cessi, cessurus", "curro, currere, cucurri, cursus", "discedo, discedere, discessi, discessurus", " dico, dicere, dixi, dictus", "duco, ducere, duxi, ductus", "gero, gerere, gessi, gestus", "lego, legere, legi, lectus", "mitto, mittere, misi, missus", "pono, ponere, posui, positus", "relinquo, relinquere, reliqui, relictus", "scribo, scribere, scripsi, scriptus", "surgo, surgere, surrexi, surrecturus", "tango, tangere, tetigi, tactus", "trado, tradere, tradidi, traditus", "traho, trahere, traxi, tractus", "verto, vertere, verti, versus", "accipio, accipere, accepi, acceptus", "aperio, aperere, aperui, apertus", "capio, capere, cepi, captus", "cupio, cupere, cupivi, cupitus", "facio, facere, feci, factus", "fugio, fugere, fūgi, fugiturus", "iacio, iacere, ieci, iactus", "advenio, advenire, advēni, adventus", "audio, audire, audivi, auditus", "dormio, dormire, dormivi, dormitus", "custodio, custodire, custodivi, custoditus", "invenio, invenire, invēni, inventus", "munio, munire, munivi, munitus", "scio, scire, scivi, scitus", "venio, venire, vēni, ventus", "sum, esse, fui", "possum, posse, potui", "agricola, agricolae", "amicitia, amicitiae", "aqua, aquae", "casa, casae", "cena, cenae", "cura, curae", "dea, deae", "fabula, fabulae", "familia, familiae", "femina, feminae", "fenestra, fenestrae", "filia, filiae", "ianua, ianuae", "insula, insulae", "ira, irae", "littera, litterae", "nauta, nautae", "patria, patriae", "pecunia, pecuniae", "puella, puellae", "regina, reginae", "silva, silvae", "terra, terrae", "unda, undae", "via, viae", "villa, villae", "vita, vitae", "aedificium, aedificii", "ager, agri", "amicus, amici", "animus, animi", "annus, anni", "auxilium, auxili", "baculum, baculi", "bellum, belli", "caelum, caeli", "captivus, captivi", " carrus, carri", " castra, castrorum", "cibus, cibi", "consilium, consili", "cubiculum, cubicula", "deus, dei", "dominus, domini", "equus, equi", "filius, filii", "frumentum, frumenti", "gladius, gladii", "inimicus, inimici", "lectus, lecti", "liber, libri", "liberi, liberorum, pl", "lupus, lupi", "oculus, oculi", "oppidum, oppidi", "numerus, numeri", "puer, pueri", "periculum, periculi", "praemium, praemi", "ramus, rami", "rivus, rivi", "servus, servi", "signum, signi", "socius, socii", "templum, templi", "verbum, verbi", "vilicus, vilici", "vir, viri", "aestas, aestatis", " arbor, arboris", "ars, artis", "canis, canis", "caput, capitis", "civis, civis", "corpus, corporis", "dux, ducis", "flumen, fluminis", "frater, fratris", "hiems, hiemis", "homo, hominis", "hostis, hostis", "iter, itineris", "lapis, lapidis", "lex, legis", "lux, lucis", "mater, matris", "miles, militis", "mors, mortis", "navis, navis", "nomen, nominis", "nox, noctis", "onus, oneris", "pars, partis", "pater, patris", "pax, pacis", "pes, pedis", "pons, pontis", "rex, regis", "senator, senatoris", "soror, sororis", "tempus, temporis", "urbs, urbis", "vox, vocis", "aqueductus, aqueductūs", "arcus, arcūs", "domus, domūs", "manus, manūs", "portus, portūs", "senatus, senatūs", "dies, diei", "fides, fidei", "res, rei", "spes, spei", "ab", "ad", "aequus, aequa, aequum", "altus, alta, altum", "amicus, amica, amicum ", "bonus, bona, bonum", "brevis, brevis, breve ", "clarus, clara, clarum", "cum", "cur", "de", "defessus, defessa, defessum ", "ex", "et ", "fessus, fessa, fessum ", "fortis, fortis, forte", "ignavus, ignava, ignavum", "in", "iratus, irata, iratum", "latus, lata, latum", "longus, longa, longum ", "magnus, magna, magnum", "malus, mala, malum", "multus, multa, multum", "noster, nostra, nostrum", "novus, nova, novum ", "parvus, parva, parvum", "per", "perterritus, perterrita, perterritum", "prope", "pulcher, pulchra, pulchrum", "–que ", "quid", "quis", "saepe", "sed", "semper", "sine", "sub", "ubi"};
    String[] dataM = {};
    String[] dataD = {};
    String CColor;
    Context context;
    LayoutInflater inflater;

    public V1RecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public V1RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.recycler_card_list, parent, false);

        V1RecyclerViewHolder viewHolder=new V1RecyclerViewHolder(v);
        return viewHolder;
    }
    public void enterData(String[] xstring){
        dataD = xstring;

    }
    public void enterData2(String[] xstring){
        dataM = xstring;

    }
    public void setColor(String c){
    CColor = c;
    }
    @Override
    public void onBindViewHolder(V1RecyclerViewHolder holder, int position) {

        holder.tv1.setText(dataD[position]);
        holder.tv2.setText(dataM[position]);
        String x = (String) holder.tv2.getText();
        CharSequence cs1 = "1st conjugation verb";
        CharSequence cs2 = "2nd conjugation verb";
        CharSequence cs3 = "3rd conjugation verb";
        CharSequence cs4 = "4th conjugation verb";
        CharSequence cs5 = "3rd -io conjugation verb";
        CharSequence cs6 = "Irregular";
        CharSequence cs7 = "1st Declension Noun";
        CharSequence cs8 = "2nd Declension Noun";
        CharSequence cs9 = "3rd Declension Noun";
        CharSequence cs10 = "4th Declension Noun";
        CharSequence cs11 = "5th Declension Noun";
        CharSequence cs12 = "Other";
        // string contains the specified sequence of char values
        boolean c1 = x.contains(cs1);
        boolean c2 = x.contains(cs2);
        boolean c3 = x.contains(cs3);
        boolean c4 = x.contains(cs4);
        boolean c5 = x.contains(cs5);
        boolean c6 = x.contains(cs6);
        boolean c7 = x.contains(cs7);
        boolean c8 = x.contains(cs8);
        boolean c9 = x.contains(cs9);
        boolean c10 = x.contains(cs10);
        boolean c11 = x.contains(cs11);
        boolean c12 = x.contains(cs12);

        CharSequence str2 = "1";
        if (c1 || CColor == "pink"){
            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_pink_500));


        }else if (c2 || CColor == "blue"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_blue_500));
        }else if (c3|| CColor == "green"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_green_500));
        }else if (c4|| CColor == "red"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_red_500));
        }else if (c5|| CColor == "purple"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_purple_500));
        }
        else if (c6|| CColor == "blueGrey"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_blue_grey_500));
        }
        else if (c7|| CColor == "lightBlue"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_light_blue_500));
        }
        else if (c8|| CColor == "teal"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_teal_500));
        }
        else if (c9|| CColor == "indigo"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_indigo_500));
        }
        else if (c10|| CColor == "orange"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_orange_500));
        }
        else if (c11|| CColor == "lightGreen"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_light_green_500));
        }
        else if (c12|| CColor == "lime"){

            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_lime_500));
        }

    }





    @Override
    public int getItemCount() {
        return dataD.length;
    }
}
