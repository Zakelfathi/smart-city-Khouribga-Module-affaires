-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 27 avr. 2023 à 02:53
-- Version du serveur : 5.7.36
-- Version de PHP : 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `smartcity`
--

-- --------------------------------------------------------

--
-- Structure de la table `centre_affaires`
--

DROP TABLE IF EXISTS `centre_affaires`;
CREATE TABLE IF NOT EXISTS `centre_affaires` (
  `nombre_bureaux_disponibles` int(11) NOT NULL,
  `tarif_horaire` double NOT NULL,
  `id_organisme` bigint(20) NOT NULL,
  PRIMARY KEY (`id_organisme`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `centre_affaires`
--

INSERT INTO `centre_affaires` (`nombre_bureaux_disponibles`, `tarif_horaire`, `id_organisme`) VALUES
(125, 20, 7);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

DROP TABLE IF EXISTS `entreprise`;
CREATE TABLE IF NOT EXISTS `entreprise` (
  `chiffre_affaires` double DEFAULT NULL,
  `form_juridique` varchar(255) DEFAULT NULL,
  `nombre_employes` int(11) NOT NULL,
  `secteur_activite` varchar(255) DEFAULT NULL,
  `id_organisme` bigint(20) NOT NULL,
  PRIMARY KEY (`id_organisme`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`chiffre_affaires`, `form_juridique`, `nombre_employes`, `secteur_activite`, `id_organisme`) VALUES
(11040000000, 'SA', 20980, 'Industrielle', 1),
(168100000000, 'SA', 181000, 'Technologie', 2),
(274500000000, 'SA', 147000, 'Technologie', 3),
(386000000000, 'SA', 1173000, 'Commerce électronique', 4),
(181690000000, 'SA', 139995, 'Technologie', 5),
(181690000000, 'SA', 139995, 'Technologie', 6);

-- --------------------------------------------------------

--
-- Structure de la table `organisation`
--

DROP TABLE IF EXISTS `organisation`;
CREATE TABLE IF NOT EXISTS `organisation` (
  `mission` varchar(255) DEFAULT NULL,
  `number_members` int(11) NOT NULL,
  `id_organisme` bigint(20) NOT NULL,
  PRIMARY KEY (`id_organisme`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `organisation`
--

INSERT INTO `organisation` (`mission`, `number_members`, `id_organisme`) VALUES
('Education - formation', 600, 8),
('Formation', 50, 9);

-- --------------------------------------------------------

--
-- Structure de la table `organisme`
--

DROP TABLE IF EXISTS `organisme`;
CREATE TABLE IF NOT EXISTS `organisme` (
  `id_organisme` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `description` longtext,
  `email` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `siteweb` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `ville_id_ville` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_organisme`),
  KEY `FK3wteefy2st6fp2lw9uigm7fu5` (`ville_id_ville`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `organisme`
--

INSERT INTO `organisme` (`id_organisme`, `adresse`, `date_creation`, `description`, `email`, `logo`, `nom`, `siteweb`, `tel`, `ville_id_ville`) VALUES
(1, '2, rue Al Abtal, Hay Erraha, Casablanca', '1920-09-07', 'Le groupe OCP, fondé le 7 août 1920 au Maroc et transformé en 2008 en une société anonyme, est le premier exportateur de phosphate brut, d’acide phosphorique et d’engrais phosphatés dans le monde.', NULL, 'logo.png', 'OCP', 'www.ocpgroup.ma', NULL, 1),
(2, 'One Microsoft Way, Redmond, WA 98052, États-Unis', '1975-05-04', 'Microsoft Corporation est une entreprise multinationale américaine de technologie qui développe, fabrique, soutient et vend des logiciels informatiques, des produits électroniques et des ordinateurs personnels.', NULL, 'logo.png', 'Microsoft', 'www.microsoft.com', NULL, 1),
(3, '1 Infinite Loop, Cupertino, CA 95014, États-Unis', '1976-05-01', 'Apple Inc. est une entreprise américaine qui conçoit et vend des produits électroniques grand public, des logiciels informatiques et des services en ligne.', NULL, 'logo.png', 'Apple', 'www.apple.com', NULL, 1),
(4, '410 Terry Ave N, Seattle, WA 98109, États-Unis', '1994-08-05', 'Amazon.com, Inc. est une entreprise américaine de commerce électronique et de services de cloud computing.', NULL, 'logo.png', 'Amazon', 'www.amazon.com', NULL, 1),
(5, '1600 Amphitheatre Pkwy, Mountain View, CA 94043, États-Unis', '2015-11-02', 'Alphabet Inc. est une entreprise holding américaine qui regroupe plusieurs filiales spécialisées dans les technologies de l\'information et de la communication, dont Google.', NULL, 'logo.png', 'Alphabet', 'www.abc.xyz', NULL, 1),
(6, '3500 Deer Creek Rd, Palo Alto, CA 94304, États-Unis', '2003-08-01', 'Tesla, Inc. est une entreprise américaine spécialisée dans la conception et la production de voitures électriques haut de gamme, de systèmes de stockage d\'énergie et de panneaux solaires.', NULL, 'logo.png', 'Tesla', 'www.tesla.com', NULL, 1),
(7, 'Bd Abdelmoumen N°236, Rue Pasquier, Immeuble F8, 2éme Etage, Bureau N°6 - Casablanca', NULL, 'Votre centre d’affaires BusinessCenter.Com vous permet de disposer d’une adresse professionnelle prestigieuse et reconnue au quartier d’affaires abdelmoumen à proximité du tramway.', 'contact@businesscenter.ma', 'logo-businesscenter.png', 'Business Center.com', 'www.businesscenter.ma', '(+212) 5 22 98 98 01', 1),
(8, 'Mail Central, 25000, Khouribga', NULL, '1337, c’est la première formation en informatique par excellence au Maroc, entièrement gratuite, ouverte 24h/24 7j/7 et accessible à tous sans pré-requis de diplôme, ou de connaissance en informatique.. C’est une immersion complète dans un univers où le futur est déjà présent, où l’informatique et les lignes de codes sont plus qu’un concept flou et rébarbatif…', '', 'logo.jpg', '1337', 'www.1337.ma', '+212522273274', 1),
(9, 'Bd Hassan II, Khouribga', NULL, 'Fondé par M. Abdelmadjid Benchekroun en 1977, diplômé de l’Ecole Spéciale des Travaux Publics (ESTP), OCBM est une histoire d’Hommes. Des Hommes qui ont façonné et sculpté l’un des fleurons marocain de la construction. Intervenant dans tous les domaines de la construction, OCBM a su satisfaire divers type de partenaires, fussent-ils publics ou privés. Différents de par leur nature, leur taille, leur degré de complexité, OCBM épouse et déploie ses ressources et son expertise sur l’ensemble de ses projets en toute autonomie.', '', 'logo.jpg', 'OCP SKILLS CENTER', 'www.ocbm.ma/realisation/centre-de-formation-ocp-khouribga/', '0641758099', 1);

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

DROP TABLE IF EXISTS `photo`;
CREATE TABLE IF NOT EXISTS `photo` (
  `id_photo` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `organisme_id_organisme` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_photo`),
  KEY `FK6am1bn8qj5sohplo7dr43fec5` (`organisme_id_organisme`),
  KEY `FKqcnufv9xflwfvi9yruuwn80bm` (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `photo`
--

INSERT INTO `photo` (`id_photo`, `url`, `organisme_id_organisme`, `type_id`) VALUES
(1, '1.jpg', 1, 4),
(2, '2.jpg', 1, 4),
(3, '3.jpg', 1, 4),
(4, '4.jpg', 1, 4),
(5, '5.jpg', 1, 4),
(6, '6.jpg', 1, 4),
(7, '7.jpg', 1, 4),
(8, '10.jpg', 1, 4),
(9, '1.jpg', 7, 4),
(10, '2.jpg', 7, 4),
(11, '3.jpg', 7, 4),
(12, '4.jpg', 7, 4),
(13, '1337-2.jpg', 8, 2),
(14, '1.jpg', 8, 4),
(15, '2.jpg', 8, 4),
(16, '3.jpg', 8, 4),
(17, '4.jpg', 8, 4),
(18, '5.jpg', 8, 4),
(19, '6.jpg', 8, 4),
(20, '7.jpg', 8, 4),
(21, '8.jpg', 8, 4),
(22, '9.jpg', 8, 4),
(23, '10.jpg', 8, 4),
(24, '1.jpg', 9, 4),
(25, '2.jpg', 9, 4),
(26, '3.jpg', 9, 4),
(27, '4.jpg', 9, 4),
(28, '5.jpg', 9, 4),
(29, '6.jpg', 9, 2);

-- --------------------------------------------------------

--
-- Structure de la table `photo_types`
--

DROP TABLE IF EXISTS `photo_types`;
CREATE TABLE IF NOT EXISTS `photo_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `photo_types`
--

INSERT INTO `photo_types` (`id`, `nom`) VALUES
(1, 'Logo'),
(2, 'Couverture'),
(3, 'Description'),
(4, 'Carousel');

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `dtype` varchar(31) NOT NULL,
  `id_ville` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `nom` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `population` int(11) NOT NULL,
  `province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ville`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`dtype`, `id_ville`, `description`, `nom`, `pays`, `population`, `province`) VALUES
('ville', 1, 'Khouribga est une ville du Maroc qui se situe à 120 km au sud-est de Casablanca. Cette cité minière est considérée comme la plus importante zone de production de phosphates du monde. L’Office chérifien des phosphates (OCP), la première entreprise publique du Maroc, exploite la zone minière du bassin d\'Ouled Abdoun et gère en partie les infrastructures sportives et sociales de la ville. Khouribga est connue par ses activités culturelles comme l\'organisation de festivals et de journées culturelles et artistiques, pour ses activités sportives : football, tennis, rugby à XV, golf, natation, handball, basketball, volleyball, karting, athlétisme…, la plupart de ces clubs dépendent de l\'Olympique Club de Khouribga (OCK) et le Hassania de Khouribga (HUSK).', 'Khouribga', 'Maroc', 542125, 'Béni Mellal - Khenifra');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
