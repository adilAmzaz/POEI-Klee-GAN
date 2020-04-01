package poeiklee.RestaurantAmbulantBack;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import poeiklee.RestaurantAmbulantBack.Models.Actuality;
import poeiklee.RestaurantAmbulantBack.Models.Command;
import poeiklee.RestaurantAmbulantBack.Models.CommandLine;
import poeiklee.RestaurantAmbulantBack.Models.Company;
import poeiklee.RestaurantAmbulantBack.Models.Individual;
import poeiklee.RestaurantAmbulantBack.Models.Product;
import poeiklee.RestaurantAmbulantBack.Repositories.ActualityRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.CommandLineRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.CommandRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.CompanyRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.IndividualRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.ProductRepository;
import poeiklee.RestaurantAmbulantBack.Repositories.UserRepository;
import poeiklee.RestaurantAmbulantBack.Models.Meal;

import poeiklee.RestaurantAmbulantBack.Repositories.MealRepository;

@SpringBootApplication
public class RestaurantAmbulantBackApplication implements CommandLineRunner {

	@Autowired
	ActualityRepository actualityRepository;
	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
	IndividualRepository individualRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CommandRepository commandRepo;
	
	@Autowired
	CommandLineRepository clr;
	@Autowired
	ProductRepository productRep;
	
	@Autowired
	MealRepository mealRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantAmbulantBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ArrayList<DayOfWeek> weekDays = new ArrayList<DayOfWeek>(Arrays.asList(
				DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));
		ArrayList<DayOfWeek> weekendDays = new ArrayList<DayOfWeek>(Arrays.asList(
				DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
		ArrayList<DayOfWeek> allDays = new ArrayList<DayOfWeek>(Arrays.asList(
				DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
		
		Meal breakfast = new Meal("Petit-déjeuner", LocalTime.of(7, 30), LocalTime.of(10, 0));
		Meal lunch = new Meal("Déjeuner", LocalTime.of(11, 30), LocalTime.of(14, 0));
		Meal teatime = new Meal("Goûter", LocalTime.of(15, 30), LocalTime.of(17, 0));
		Meal dinner = new Meal("Dîner", LocalTime.of(18, 30), LocalTime.of(22, 0));
		
		ArrayList<Meal> strongMeals = new ArrayList<Meal>(Arrays.asList(lunch, dinner));
		ArrayList<Meal> lightMeals = new ArrayList<Meal>(Arrays.asList(breakfast, teatime));
		ArrayList<Meal> allMeals = new ArrayList<Meal>(Arrays.asList(breakfast, lunch, teatime, dinner));
		ArrayList<Meal> breakfastOnly = new ArrayList<Meal>(Arrays.asList(breakfast));
		
		mealRepository.save(breakfast);
		mealRepository.save(lunch);
		mealRepository.save(teatime);
		mealRepository.save(dinner);
		
		productRepository.save(new Product("Rôti de bœuf au feu de bois", "images/product/roti.jpg", 
				"Viande de bœuf et condiments", 12.0, 10, 115, strongMeals, allDays));
		productRepository.save(new Product("Pain au chocolat", "images/product/chocolatine.jpg", 
				"Pâte feuilletée et chocolat", 1.1, 25, 1023, lightMeals, allDays));
		productRepository.save(new Product("Pommes de terre frites", "images/product/frites.jpg", 
				"Pommes de terre et condiments", 3.5, 33, 841, strongMeals, allDays));
		productRepository.save(new Product("Chocolat chaud", "images/product/chocolat.jpg", 
				"Lait, chocolat et sucre", 2.0, 18, 910, lightMeals, allDays));
		productRepository.save(new Product("Spaghetti à la carbonara", "images/product/carbonara.jpg", 
				"Pâtes, lardons, crême et parmesan", 10.5, 12, 511, strongMeals, allDays));
		productRepository.save(new Product("Soupe à la tomate", "images/product/soupe.jpg", 
				"Tomate, pomme de terre, oignon et condiments", 4.6, 18, 652, strongMeals, weekDays));
		productRepository.save(new Product("Brochettes d'agneau braisé", "images/product/brochettes.jpg", 
				"Viande d'agneau, oignon, courgette, poivron et condiments", 15.0, 4, 59, strongMeals, weekendDays));
		productRepository.save(new Product("Jus d'orange frais", "images/product/jus.jpg", 
				"Pâte feuilletée et chocolat", 1.8, 43, 1637, allMeals, allDays));
		productRepository.save(new Product("Salade de fruits", "images/product/saladefruits.jpg", 
				"Fruits de saison", 5.0, 22, 711, allMeals, allDays));
		productRepository.save(new Product("Poulet frit", "images/product/poulet.jpg", 
				"Viande de poulet et panure", 8.0, 19, 813, strongMeals, weekDays));
		productRepository.save(new Product("Gratin de chou-fleur", "images/product/gratin.jpg", 
				"Chou-fleur, sauce béchamel et emmental", 8.5, 14, 546, strongMeals, weekDays));
		productRepository.save(new Product("Boudin aux pommes", "images/product/boudin.jpg", 
				"Boudin noir et pommes caramélisées", 14.8, 3, 48, strongMeals, DayOfWeek.SUNDAY));
		productRepository.save(new Product("Croissant au beurre", "images/product/croissant.jpg", 
				"Pâte feuilletée et beurre", 0.9, 34, 1181, lightMeals, allDays));
		productRepository.save(new Product("Petit-déjeuner anglais traditionnel", "images/product/british.jpg", 
				"Toasts, œufs sur le plat, bacon, saucisses, tomates, galette de pommes de terre et champignons", 1.1, 25, 1023, breakfastOnly, weekendDays));
		productRepository.save(new Product("Salade césar", "images/product/salade.jpg", 
				"Salade verte, poulet grillé, croûtons et assaisonnement", 9.9, 15, 592, strongMeals, allDays));
		
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
		Company c = new Company("company", "123", "phone", "addess", "zipecode", "city", "name");
		Company c2 = new Company("company2", "123", "phone", "addess", "zipecode", "city", "name");
		Company c3 = new Company("company3", "123", "phone", "addess", "zipecode", "city", "name");
		Company c4 = new Company("company4", "123", "phone", "addess", "zipecode", "city", "name");

		Individual i3 = new Individual("aa@aa.fr", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		Individual i5 = new Individual("zz@zz.fr", "password", "phone", "address", "zipecode", "city", "latname", "fristname", true,   LocalDate.now(), true);
		Individual i1 = new Individual("antoin@mail.com", "password", "0635845692", "Rue la République", "75011", "Paris", "Antoi", "Daniel", false,   LocalDate.now(), false);
		Individual i4 = new Individual("eliot@mail.com", "password", "0624582695", "Boulevard La Borie", "75001", "Paris", "Elliot", "Aronson", false,   LocalDate.now(), true);


		Command c1 = new Command(1, LocalDateTime.now(), LocalDateTime.now(), false, LocalDateTime.now(), false, "Boulevard La Borie", "75001", "Paris");
		Command c6 = new Command(3, LocalDateTime.now(), LocalDateTime.now(), false, LocalDateTime.now(), false, "Boulevard La Borie", "75001", "Paris");
		Command c7 = new Command(4, LocalDateTime.now(), LocalDateTime.now(), false, LocalDateTime.now(), false, "Boulevard La Borie", "75001", "Paris");
		Command c5 = new Command(5, LocalDateTime.now(), LocalDateTime.now(), false, LocalDateTime.now(), false, "Rue la République", "75011", "Paris");
		c1.setUser(i4);
		c6.setUser(i4);
		c7.setUser(i4);
		c5.setUser(i1);
		Product p1 = new Product("label", "imageRelp", "comp", 12.0, 10);
		Product p2 = new Product("label", "imageRelp", "comp", 12.0, 10);
		Product p3 = new Product("label", "imageRelp", "comp", 12.0, 10);

		CommandLine cl = new CommandLine();
		cl.setCommand(c1);
		cl.setCommandLineId(1);
		cl.setEffectivePrice(10.2);
		cl.setProduct(p1);
		cl.setQuantity(2);
		
		CommandLine cl2 = new CommandLine();
		cl2.setCommand(c1);
		cl2.setCommandLineId(2);
		cl2.setEffectivePrice(10.2);
		cl2.setProduct(p1);
		cl2.setQuantity(2);		
		
	
		productRep.save(p1);
		productRep.save(p2);
		productRep.save(p3);
		individualRepo.save(i3);

		companyRepo.save(c2);
		companyRepo.save(c);
		companyRepo.save(c3);
		companyRepo.save(c4);
		
		//individualRepo.save(i);
		individualRepo.save(i1);
		individualRepo.save(i3);
		individualRepo.save(i4);
		individualRepo.save(i5);
		commandRepo.save(c1);
		commandRepo.save(c6);
		commandRepo.save(c7);
		commandRepo.save(c5);
		
		clr.save(cl);
		clr.save(cl2);
	}
	


}
