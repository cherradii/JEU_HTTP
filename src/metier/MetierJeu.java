package metier;

public class MetierJeu {
	private int nombreSecret;
	private boolean fin;
	
	public void genererSecret() {
		nombreSecret = (int) (Math.random()*1000);
	}
	
	public String jouer(int nb) {
		if (fin == false) {
			if (nb > nombreSecret) {
				return "Votre nombre est plus grand";
			} else if (nb < nombreSecret) {
				return "Votre nombre est plus petit";
			} else {
				fin = true;
				return "Bravo vous avez gagné";
			}				
		} else  {
			return "Le jeu est terminé, le nombre recherché est " + nombreSecret;
		}
	}
	
}
