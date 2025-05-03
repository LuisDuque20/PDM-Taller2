package com.pdmtaller2.LDuque_00013423

val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Hut",
        description = "Ven a comer con pizza puch",
        imageUrl = R.drawable.pizzahut,
        categories = listOf("Pizzas", "Postres y Dulces", "Comida rapida"),
        menu = listOf(
            Dish(1, "Pizza Pepperoni", "Rica pizza de pepperoni", R.drawable.pizzapep),
            Dish(2, "Pizza de Jamón", "Rica pizza de jamón con queso mozzarella", R.drawable.pizzajam),
            Dish(3, "Pizza Suprema", "Pizza con todos los ingredientes", R.drawable.pizzasup),
            Dish(4, "Brownie de Chocolate", "Brownie tibio con chispas de chocolate", R.drawable.brownie),
            Dish(5, "Cinnamon Rolls", "Rollos de canela glaseados", R.drawable.cinnamonn)
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King",
        description = "Deliciosas hamburguesas y más",
        imageUrl = R.drawable.burgerking,
        categories = listOf("Hamburguesas", "Papas Fritas", "Comida rapida"),
        menu = listOf(
            Dish(6, "Whopper", "Hamburguesa con carne de res, lechuga, tomate y cebolla", R.drawable.whopper),
            Dish(7, "Chicken Fries", "Tiras de pollo empanizadas", R.drawable.chickenfries),
            Dish(8, "Cheeseburger", "Hamburguesa con queso", R.drawable.cheeseburger),
            Dish(9, "Papas Fritas Grandes", "Papas crujientes con sal", R.drawable.papasfritasg),
            Dish(10, "Nuggets de Pollo", "Piezas de pollo empanizado", R.drawable.nuggets)
        )
    ),
    Restaurant(
        id = 3,
        name = "Sushi Itto",
        description = "Auténtico sushi japonés",
        imageUrl = R.drawable.sushiitto,
        categories = listOf("Sushi", "Rollos", "Comida asiatica"),
        menu = listOf(
            Dish(11, "California Roll", "Rollos de sushi con aguacate, cangrejo y pepino", R.drawable.californiaroll),
            Dish(12, "Tempura Roll", "Rollos de sushi con camarones tempura", R.drawable.tempuraroll),
            Dish(13, "Philadelphia Roll", "Rollos con queso crema y salmón", R.drawable.philiroll),
            Dish(14, "Yakimeshi", "Arroz frito japonés", R.drawable.yakimeshi),
            Dish(15, "Gyozas", "Empanadas japonesas rellenas", R.drawable.gyoza)
        )
    ),
    Restaurant(
        id = 4,
        name = "Taco Bell",
        description = "Experimenta la mejor comida mexicana en SV",
        imageUrl = R.drawable.tacobell,
        categories = listOf("Tacos", "Burritos", "Comida mexicana"),
        menu = listOf(
            Dish(16, "Crunchy Taco", "Taco crujiente con carne, lechuga y queso", R.drawable.crunchy),
            Dish(17, "Bean Burrito", "Burrito de frijoles con queso y salsa", R.drawable.beanburrito),
            Dish(18, "Quesadilla de Pollo", "Quesadilla con queso y pollo", R.drawable.quesadillapollo),
            Dish(19, "Nachos Supremos", "Nachos con carne, queso y jalapeños", R.drawable.nachossup),
            Dish(20, "Taco Supreme", "Taco con crema, lechuga y tomate", R.drawable.tacosup)
        )
    ),
    Restaurant(
        id = 5,
        name = "KFC",
        description = "Pollo frito y más",
        imageUrl = R.drawable.kfc,
        categories = listOf("Pollo", "Complementos", "Comida rapida"),
        menu = listOf(
            Dish(21, "Original Recipe Chicken", "Pollo frito con receta original", R.drawable.chickenkfc),
            Dish(22, "Mashed Potatoes", "Puré de papas con salsa", R.drawable.kfcmashes),
            Dish(23, "Famous Bowl", "Tazón de puré, maíz, pollo y queso", R.drawable.kfcfamousbowl),
            Dish(24, "Mac & Cheese", "Macarrones con queso", R.drawable.kfcmachesse),
            Dish(25, "Pollo Picante", "Pollo frito extra crujiente", R.drawable.chickenkfc)
        )
    ),
    Restaurant(
        id = 6,
        name = "Olive Garden",
        description = "Lo mejor de la comida italiana",
        imageUrl = R.drawable.olivegarden,
        categories = listOf("Comida italiana", "Pasta", "Ensaladas"),
        menu = listOf(
            Dish(26, "Lasagna", "Lasaña con carne y salsa marinara", R.drawable.lasagna),
            Dish(27, "Fettuccine Alfredo", "Pasta con salsa Alfredo", R.drawable.alfredo),
            Dish(28, "Spaghetti con albóndigas", "Espaguetis con albóndigas caseras", R.drawable.espagueti),
            Dish(29, "Ensalada Italiana", "Ensalada fresca con aderezo italiano", R.drawable.ensaladaitaliana),
            Dish(30, "Pan de ajo", "Pan horneado con ajo y mantequilla", R.drawable.pandeajo)
        )
    ),
    Restaurant(
        id = 7,
        name = "Green Bowl",
        description = "Opciones frescas y saludables",
        imageUrl = R.drawable.greenbowl,
        categories = listOf("Comida saludable", "Ensaladas", "Vegetariano"),
        menu = listOf(
            Dish(31, "Bowl de Quinoa", "Quinoa con vegetales y hummus", R.drawable.quinoa),
            Dish(32, "Wrap de Pollo", "Wrap integral con pollo y vegetales", R.drawable.wrapdepollo),
            Dish(33, "Smoothie Verde", "Batido con espinaca, plátano y manzana", R.drawable.smothie),
            Dish(34, "Ensalada César", "Ensalada con pollo, crutones y aderezo césar", R.drawable.cesar),
            Dish(35, "Tazón vegano", "Tazón con tofu y vegetales al vapor", R.drawable.vegan)
        )
    ),
    Restaurant(
        id = 8,
        name = "Sweet Paradise",
        description = "Dulces para cada antojo",
        imageUrl = R.drawable.sweetparadise,
        categories = listOf("Postres y Dulces", "Repostería"),
        menu = listOf(
            Dish(36, "Cheesecake", "Pastel de queso con frutas", R.drawable.cheesecake),
            Dish(37, "Brownie", "Brownie de chocolate con nueces", R.drawable.brownie),
            Dish(38, "Cupcake de vainilla", "Cupcake con frosting de vainilla", R.drawable.cupcake),
            Dish(39, "Tarta de Manzana", "Tarta caliente con manzana y canela", R.drawable.tartademanzana),
            Dish(40, "Donas Glaseadas", "Donas con glaseado de azúcar", R.drawable.donas)
        )
    ),
    Restaurant(
        id = 9,
        name = "Bebidas & Más",
        description = "Bebidas refrescantes para todos",
        imageUrl = R.drawable.bebidas,
        categories = listOf("Bebidas", "Jugos", "Smoothies"),
        menu = listOf(
            Dish(41, "Limonada", "Limonada natural con hielo", R.drawable.limonada),
            Dish(42, "Té Helado", "Té negro con limón", R.drawable.te),
            Dish(43, "Smoothie de Fresa", "Batido de fresa con yogurt", R.drawable.sfresa),
            Dish(44, "Café Latte", "Café con leche espumada", R.drawable.latte),
            Dish(45, "Chocolate Caliente", "Bebida caliente con cacao y leche", R.drawable.chocolatecaliente)
        )
    ),
    Restaurant(
        id = 10,
        name = "La Taquería del Sol",
        description = "Tacos auténticos mexicanos",
        imageUrl = R.drawable.taqueria,
        categories = listOf("Comida mexicana", "Tacos", "Antojitos"),
        menu = listOf(
            Dish(46, "Tacos al Pastor", "Tacos con carne de cerdo y piña", R.drawable.tacospastor),
            Dish(47, "Tacos de Barbacoa", "Tacos con carne de res deshebrada", R.drawable.tacosbarbacoa),
            Dish(48, "Quesadilla de queso", "Tortilla de maíz con queso derretido", R.drawable.quesadillapollo),
            Dish(49, "Sopes", "Base de maíz con frijoles, carne y crema", R.drawable.sopes),
            Dish(50, "Tamales", "Tamales de elote y de pollo", R.drawable.tamales)
        )
    ),
    Restaurant(
        id = 11,
        name = "Ramen House",
        description = "Sabores auténticos de Japón",
        imageUrl = R.drawable.ramenhouse,
        categories = listOf("Comida asiatica", "Japonesa", "Sopas"),
        menu = listOf(
            Dish(51, "Ramen Tonkotsu", "Ramen con caldo de cerdo y huevo", R.drawable.tonkotsu),
            Dish(52, "Ramen Shoyu", "Ramen con salsa de soya", R.drawable.shoyu),
            Dish(53, "Ramen Picante", "Ramen con caldo picante", R.drawable.te),
            Dish(54, "Takoyaki", "Bolas de pulpo japonesas", R.drawable.ramenpicante),
            Dish(55, "Onigiri", "Triángulos de arroz rellenos", R.drawable.onigiri)
        )
    ),
    Restaurant(
        id = 12,
        name = "La Vita è Bella",
        description = "Sabores tradicionales de Italia",
        imageUrl = R.drawable.lavitaebella,
        categories = listOf("Comida italiana", "Pasta", "Pizzas"),
        menu = listOf(
            Dish(56, "Risotto", "Arroz cremoso con hongos", R.drawable.rissotto),
            Dish(57, "Pizza Margherita", "Pizza con tomate, mozzarella y albahaca", R.drawable.margarita),
            Dish(58, "Ravioli", "Pasta rellena con ricotta", R.drawable.ravioli),
            Dish(59, "Minestrone", "Sopa italiana de vegetales", R.drawable.minestrone),
            Dish(60, "Bruschetta", "Pan tostado con tomate y ajo", R.drawable.bruscheta)
        )
    ),
    Restaurant(
        id = 13,
        name = "Fresh & Fit",
        description = "Tu lugar para comer sano",
        imageUrl = R.drawable.freshandfit,
        categories = listOf("Comida saludable", "Vegano", "Bajo en calorías"),
        menu = listOf(
            Dish(61, "Ensalada de quinoa", "Quinoa con espinaca, zanahoria y aderezo de limón", R.drawable.quinoa),
            Dish(62, "Tazón de acai", "Acai con frutas y granola", R.drawable.acai),
            Dish(63, "Sopa de lentejas", "Lentejas con vegetales", R.drawable.lentejas),
            Dish(64, "Wrap vegano", "Tortilla integral con tofu y hummus", R.drawable.wrapvegano),
            Dish(65, "Batido detox", "Jugo verde con pepino y apio", R.drawable.smothie)
        )
    ),
    Restaurant(
        id = 14,
        name = "RefrescArte",
        description = "Bebidas artesanales y naturales",
        imageUrl = R.drawable.refrescarte,
        categories = listOf("Bebidas", "Jugos Naturales", "Tés"),
        menu = listOf(
            Dish(66, "Agua de Jamaica", "Bebida fría de flor de Jamaica", R.drawable.jamaica),
            Dish(67, "Licuado de Plátano", "Batido de plátano con leche", R.drawable.platano),
            Dish(68, "Té Verde con Menta", "Té natural servido frío", R.drawable.platano),
            Dish(69, "Smoothie Tropical", "Smoothie con mango y piña", R.drawable.smothietropical),
            Dish(70, "Agua de Horchata", "Bebida de arroz con canela", R.drawable.horchata)
        )
    )

)
