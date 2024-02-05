package toolsforrpg_panpalianos;

import java.util.Comparator;
import java.util.List;

import toolsforrpg_panpalianos.fichas.FichaCriatura;

//TODO colocar média dos status

public class Estatisticas { 

    public static String executar(List<FichaCriatura> fichas){

        //Neste método, estou usando o comparador para ordenar as lista de fichas de forma crescente.
        //A partir disso, consigo ver, por exemplo, qual personagem tem o maior atributo de força

        String mensagem = "Estatísticas (Menor e Maior)\n\n";

        fichas.sort(Comparator.comparingInt(FichaCriatura::getQuantPVs));
        mensagem += "PVs: "+gerarMensagemMaiorMenor(fichas, 1)+"\n";

        fichas.sort(Comparator.comparingInt(FichaCriatura::getForca));
        mensagem += "Força: "+gerarMensagemMaiorMenor(fichas, 2);

        fichas.sort(Comparator.comparingInt(FichaCriatura::getDestreza));
        mensagem += "Destreza: "+gerarMensagemMaiorMenor(fichas, 3);

        fichas.sort(Comparator.comparingInt(FichaCriatura::getConstituicao));
        mensagem += "Constituição: "+gerarMensagemMaiorMenor(fichas, 4);

        fichas.sort(Comparator.comparingInt(FichaCriatura::getInteligencia));
        mensagem += "Inteligência: "+gerarMensagemMaiorMenor(fichas, 5);

        fichas.sort(Comparator.comparingInt(FichaCriatura::getSabedoria));
        mensagem += "Sabedoria: "+gerarMensagemMaiorMenor(fichas, 6);

        fichas.sort(Comparator.comparingInt(FichaCriatura::getCarisma));
        mensagem += "Carisma: "+gerarMensagemMaiorMenor(fichas, 7)+"\n";

        fichas.sort(Comparator.comparingInt(FichaCriatura::getQuantDVs));
        mensagem += "DVs: "+gerarMensagemMaiorMenor(fichas, 8);

        fichas.sort(Comparator.comparingInt(FichaCriatura::getClasseArmadura));
        mensagem += "CA: "+gerarMensagemMaiorMenor(fichas, 9);

        fichas.sort(Comparator.comparingInt(FichaCriatura::getJogadaDeProtecao));
        mensagem += "JP: "+gerarMensagemMaiorMenor(fichas, 10);

        fichas.sort(Comparator.comparingInt(FichaCriatura::getBaseAtaque));
        mensagem += "BA: "+gerarMensagemMaiorMenor(fichas, 11);

        return mensagem;

    }

    private static String gerarMensagemMaiorMenor(List<FichaCriatura> fichas, int opcao){

        String msgMenorAtributo = "";
        String msgMaiorAtributo = "";

        final int QUANT_PVS =       1;
        final int FORCA =           2;
        final int DESTREZA =        3;
        final int CONSTITUICAO =    4;
        final int INTELIGENCIA =    5;
        final int SABEDORIA =       6;
        final int CARISMA =         7;
        final int DV =              8;
        final int CA =              9;
        final int JP =              10;
        final int BA =              11;

        switch (opcao) {

            case QUANT_PVS:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getQuantPVs();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getQuantPVs();
                break;

            case FORCA:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getForca();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getForca();
                break;

            case DESTREZA:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getDestreza();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getDestreza();
                break;

            case CONSTITUICAO:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getConstituicao();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getConstituicao();
                break;

            case INTELIGENCIA:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getInteligencia();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getInteligencia();
                break;

            case SABEDORIA:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getSabedoria();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getSabedoria();
                break;

            case CARISMA:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getCarisma();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getCarisma();
                break;

            case DV:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getQuantDVs();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getQuantDVs();
                break;

            case CA:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getClasseArmadura();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getClasseArmadura();
                break;

            case JP:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getJogadaDeProtecao();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getJogadaDeProtecao();
                break;

            case BA:
                msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getBaseAtaque();
                msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getBaseAtaque();
                break;
        
            default:
                break;
        }
       
        return msgMenorAtributo+" / "+msgMaiorAtributo+"\n";
    }

}