package org.telran.shop.de;

import org.springframework.boot.CommandLineRunner;

/**
 * @ComponentScan - указывает путь для сканирования пакетов, для поиска
 * классов помеченных нижеуказанными аннотациями
 * @Component - помечаем классы как кандидаты в спринг бины
 * @Controller - помечаем классы контроллеры-аналог компонент
 * @Service - помечаем классы сервисы-аналог компонент
 * <p>
 * Constructor injection
 * Setter injection
 * Field injection (use @Autowired)
 * @Autowired - указывает спрингу, что сюда нужно внедрить зависимость(bean)!!!
 */

//@SpringBootApplication
public class ShopApp implements CommandLineRunner {

//    @Autowired
//    private ProductController controller;
//
//    public static void main(String[] args) {
//        SpringApplication.run(ShopApp.class, args);
//    }

    @Override
    public void run(String... args) throws Exception {
//        List<Product> all = controller.getAll();
//        System.out.println(all);
    }
}
