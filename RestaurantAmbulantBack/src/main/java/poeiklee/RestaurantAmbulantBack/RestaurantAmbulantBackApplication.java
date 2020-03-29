package poeiklee.RestaurantAmbulantBack;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import poeiklee.RestaurantAmbulantBack.Models.Actuality;
import poeiklee.RestaurantAmbulantBack.Repositories.ActualityRepository;

@SpringBootApplication
public class RestaurantAmbulantBackApplication implements CommandLineRunner {

	@Autowired
	ActualityRepository actualityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantAmbulantBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Actuality actuality1 = new Actuality("Hello world", 
				"L'équipe", 
				"Un nouveau système d'actualité voit le jour : vous connaîtrez toutes les dernières nouvelles de votre Restautant Ambulant !", 
				"images/actuality/helloworld.png", 
				"Nous sommes si heureux de vous présenter cette nouvelle fonctionnalité de notre site : "
						+ "des actualités qui vous tiendront constamment au jus ! Dans cette rubrique spéciale, nous vous signalerons les évolutions de la carte et "
						+ "des menus bien sûr, ou encore les dernières promotions. Mais nous vous dispenserons également des conseils culinaires ou de bien-être, "
						+ "et nous partagerons les aventures parfois hors du commun vécues par notre équipe !<br><br>La bise ravie", 
				LocalDateTime.of(2019, 9, 1, 11, 42));
		actualityRepository.save(actuality1);
		Actuality actuality2 = new Actuality("Coronavirus : la Belgique, toujours en manque de masques, possédait un stock important mais l’a détruit", 
				"Jean-Pierre Stroobants",
				"La question des masques est une véritable saga dans le royaume depuis le début de la pandémie. Un stock de plusieurs millions d’entre eux a ainsi été "
						+ "supprimé en 2017 ou 2018 sans avoir été renouvelé.",
				"images/actuality/belgique.png",
				"Comme beaucoup de pays touchés par la pandémie de Covid-19, la Belgique manque toujours de masques, notamment les plus performants à destination des "
						+ "médecins et des personnels soignants en première ligne. Pourtant, elle en a détruit des millions en 2017 ou 2018 : ils étaient certes périmés, "
						+ "mais le stock n’a pas été renouvelé, contrairement aux recommandations de l’Organisation mondiale de la santé (OMS).<br><br>"
						+ "La question des masques est une véritable saga dans le royaume depuis le début de la pandémie. Régulièrement mise sur la sellette, la "
						+ "ministre fédérale de la santé, Maggie De Block, une libérale flamande, tient des propos rassurants, mais souvent contredits par le personnel "
						+ "médical. Lors d’un épisode de ce feuilleton, on a découvert qu’une commande effectuée en Turquie avait échoué en raison d’une fraude ; à une "
						+ "autre occasion des masques arrivés de Chine, et promis aux soignants, se sont révélés d’une qualité insuffisante.<br><br>"
						+ "Des révélations plus étonnantes encore sont venues émailler l’actualité. Au début de la semaine, des journaux révélaient qu’une importante "
						+ "réserve de masques de type FFP2 − les plus étanches − avait été entreposée dans une caserne mais étaient hors d’usage. Six millions "
						+ "d’exemplaires ont ainsi été détruits sur ordre du ministère de la santé, affirme le Parti du travail (PTB, gauche radicale), sur la base de "
						+ "documents officiels. Et la ministre De Block a décidé de ne pas les remplacer, refusant de signer une commande si elle ne prévoyait pas le "
						+ "remplacement du stock quand celui-ci serait arrivé à sa date de péremption.<br><br>"
						+ "En guise de réponse le cabinet de Mme De Block a affirmé qu’il était, à l’époque, hors de question de « <i>gaspiller l’argent du contribuable"
						+ "</i> » et qu’il devait s’en tenir à des règles complexes. Une seule certitude : les réserves détruites n’ont jamais été remplacées, ce qui "
						+ "explique les difficultés auxquelles est actuellement confronté le pays.<br><br>"
						+ "« <i>Irresponsable</i> », juge Rudy Demotte (PS), l’un des prédécesseurs de Mme De Block à la tête du département de la santé. Entre 2003 et "
						+ "2007, moment de premières épidémies (SRAS et grippe aviaire), il avait commandé 38 millions de masques, dont 6 millions de FFP2.<br><br>"
						+ "Mme De Block, médecin généraliste de profession, a été souvent critiquée pour sa volonté de limiter fortement la croissance du budget de son "
						+ "département. Son cabinet conteste toutefois qu’elle ait voulu faire des économies en renonçant à commander des matériels essentiels. Elle "
						+ "aurait seulement voulu « <i>une réflexion approfondie</i> » sur le meilleur moyen de s’en procurer mais aurait été la victime des lenteurs "
						+ "dues, notamment, aux exigences de rigueur budgétaire et aux crises politiques à répétition.<br><br>"
						+ "« <i>Une fois la pandémie terminée, je demanderai qu’une commission d’enquête parlementaire soit mise en place pour enquêter de manière "
						+ "approfondie sur cette question</i> », annonce Sofie Merckx, médecin et députée du PTB.",
				LocalDateTime.of(2020, 3, 25, 22, 27));
		actualityRepository.save(actuality2);
		for (int i = 0; i < 100; i++)
			actualityRepository.save(new Actuality("Test n°" + (i + 1), "M. Test", "Ceci est le test n°" + (i + 1) + ".", "images/actuality/test.jpg", 
					"Si nous vous testions le test, que testeriez-vous ? Un sacré test en perspective...", LocalDateTime.of(2019-i, 9, 1, 12, 36)));
	}
	


}
