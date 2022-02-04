package ultraemojicombat;

import java.util.Random;

/**
 * @author Mattg
 */
public class Luta {
    private Lutador desafiado;   //isso é uma agregaçao da classe luta e lutador
    private Lutador desafiante; //
    private int rounds;
    private boolean aprovada;

    public Luta() {
        this.setRounds(1);
    }
    
    public void marcarLuta(Lutador L1, Lutador L2){
        if(L1.getCategoria() != L2.getCategoria()){
            System.out.println("Falha ao Marcar Luta...Lutadores de Categorias Diferentes");
            this.setAprovada(false);
            this.setDesafiado(null);
            this.setDesafiante(null);
        }else{
            if(L1.getNome().equals(L2.getNome())){
                System.out.println("Falha ao Marcar Luta...MESMO lUTADOR");
                this.setAprovada(false);
                this.setDesafiado(null);
                this.setDesafiante(null);
            }else{
                this.setAprovada(true);
                this.setDesafiado(L1);
                this.setDesafiante(L2);
            }
        }
    }  
    
    public void lutar(){
        if(this.getAprovada()){
            System.out.println("      ### DESAFIADO ###");
            this.desafiado.apresentarLutador();
            System.out.println("\n\n     ### DESAFIANTE ###");
            this.desafiante.apresentarLutador();
            int vencedor;
            int flagL1=0;
            int flagL2=0;
            
            while(this.getRounds() <= 3){
                Random ale = new Random();
                vencedor = ale.nextInt(3);//gera 0 ou 1 ou 2
                
                switch(vencedor){
                    case 0:
                        System.out.println("\n==============================\nROUND " + this.getRounds() + " EMPATOUUUUU\n==============================");
                        break;
                    case 1:
                        System.out.println("\n==============================\nWINNER ROUND " + this.getRounds() + ": " +   this.desafiado.getNome() + "\n==============================");
                        flagL1++;
                        break;
                    case 2:
                        System.out.println("\n==============================\nWINNER ROUND " + this.getRounds() + ": " +   this.desafiante.getNome() + "\n==============================");
                        flagL2++;
                        break;
                    default:
                        System.out.println("\nDEU MERDA KKK");
                }               
                
                //MELHOR DE 3.. ENT SE UM LUTADOR JA VENCEU 2 ROUNDS NÃO DISPUTARA O 3º
                if(flagL1 == 2){//desafiado
                    this.setRounds(3);
                }else if(flagL2 == 2){//desafiante
                    this.setRounds(3);
                }             
            
                this.setRounds(this.getRounds()+1);
            }
            
            if(flagL1 > flagL2){//desafiado
                System.out.println("\n********************************\nO VENCEDOR DA LUTA É: " + this.desafiado.getNome() + "\n********************************" );
                this.desafiado.ganharLuta();
                this.desafiante.perderLuta();
            }else if(flagL2 > flagL1){
                System.out.println("\n********************************\nO VENCEDOR DA LUTA É: " + this.desafiante.getNome() + "\n********************************" );
                this.desafiante.ganharLuta();
                this.desafiado.perderLuta();
            }else if(flagL1 == flagL2){
                System.out.println("\n*******************************\n          EMPATE GERAL\n*******************************");
                this.desafiado.empatarLuta();
                this.desafiante.empatarLuta();
            }
  
        }else{
            System.out.println("ERROR...LUTA NÃO APROVADA");
        }
        
        
        
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiando) {
        this.desafiado = desafiando;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    
}
