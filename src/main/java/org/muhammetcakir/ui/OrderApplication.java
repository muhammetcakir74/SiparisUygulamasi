package org.muhammetcakir.ui;

import org.muhammetcakir.data.customer.*;
import org.muhammetcakir.model.*;
import org.muhammetcakir.service.IBaseService;
import org.muhammetcakir.service.impl.Company.CompanyService;
import org.muhammetcakir.service.impl.Company.ICompanyService;
import org.muhammetcakir.service.impl.bill.BillService;
import org.muhammetcakir.service.impl.bill.IBillService;
import org.muhammetcakir.service.impl.customer.CustomerService;
import org.muhammetcakir.service.impl.customer.ICustomerService;
import org.muhammetcakir.service.impl.order.IOrderService;
import org.muhammetcakir.service.impl.order.OrderService;
import org.muhammetcakir.service.impl.product.IProductService;
import org.muhammetcakir.service.impl.product.ProductService;
import org.muhammetcakir.utils.CustomDateFormatter;
import org.muhammetcakir.utils.CustomScanner;
import org.muhammetcakir.utils.DefaultModelCreator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

public class OrderApplication {
    private CompanyDao companyDao = new CompanyDao();
    private ProductDao productDao = new ProductDao();
    private CustomerDao customerDao = new CustomerDao();
    private OrderDao orderDao = new OrderDao();
    private BillDao billDao = new BillDao();


    private ICustomerService customerService = new CustomerService(customerDao);

    private DefaultModelCreator defaultModelCreator = new DefaultModelCreator(companyDao,productDao,customerDao);
    private ICompanyService companyService = new CompanyService(companyDao);
    private IProductService productService = new ProductService(productDao);

    private IOrderService orderService = new OrderService(orderDao);
    private IBillService billService = new BillService(billDao);

    public OrderApplication() {
        writeMainMenu();

    }

    public void writeMainMenu(){
        System.out.println("---------------Lütfen yapmak istediğiniz işlemi seçip 'ENTER' tuşuna basınız--------------");
        System.out.println("1- Kullanıcı ekle");
        System.out.println("2- Kullanıcıları listele");
        System.out.println("3- Sipariş oluştur");
        System.out.println("4- İçerisinde 'C' harfi olan müşterileri listele");
        System.out.println("5- Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarını listele");
        System.out.println("6- Faturaları listele");
        System.out.println("7- 1500TL üzerindeki faturaları listele");
        System.out.println("8- 1500TL üzerindeki faturaların ortalamasını listele");
        System.out.println("9- 500TL altındaki faturaya sahip müşterilerin isimlerini listele");

        int number = Integer.parseInt(CustomScanner.requestFromClient("Seçiminiz"));
        chooseProcess(number);
    }

    private void getCustomers(){
        List<Customer> customerList = customerService.getAll();
        for (Customer customer:customerList){
            System.out.println("Id: "+customer.getId()+" İsim: "+customer.getFirstName()+" Soyisim: "+customer.getLastName());
        }
        writeMainMenu();
    }

    private void addCustomer(){
        String customerName = CustomScanner.requestFromClient("Kullanıcı Adı: ");
        String customerSurName = CustomScanner.requestFromClient("Kullanıcı Soyadı: ");
        String customerAddress = CustomScanner.requestFromClient("Kullanıcı Adresi: ");
        customerService.addCustomer(customerName,customerSurName,customerAddress);
        System.out.println("Kullanıcı başarıyla eklendi");
        writeMainMenu();
    }

    private void chooseCompany(){
        System.out.println("----------Hangi marketten alış veriş yapacağınızı seçiniz-----------");
        List<Company> companies = companyService.getAll();
        for (int i=0;i<companies.size();i++){
            System.out.println(i+"- Şirket ismi: "+companies.get(i).getName()+" Sektör: "+companies.get(i).getField());
        }
        String number = CustomScanner.requestFromClient("Seçimiz: ");
        listOfCompanyProducts(number);

    }

    private void listOfCompanyProducts(String number){
        List<Product> filteredProductList = productService.filterProductAccordingToCompany(number);
        for (int i=0;i<filteredProductList.size();i++){
            System.out.println("Id: "+filteredProductList.get(i).getId()+" İsim: "+filteredProductList.get(i).getProductName()+" Fiyat: "+filteredProductList.get(i).getPrice());
        }
        String productId = CustomScanner.requestFromClient("Satın alacağınız ürün: ");
        createOrder(productId);
    }

    private void createOrder(String productId){
        Customer customer = (Customer) customerService.findById("0");
        Product product = (Product) productService.findById(productId);
        Company company = (Company) companyService.findById(product.getCompany().getId());



        Order newOrder = new Order(String.valueOf(orderDao.numberOfOrders()+1), CustomDateFormatter.formatDateToJune(),product,customer);
        orderService.add(newOrder);
        System.out.println(product.getProductName()+" isimli ürünü başarıyla satın aldınız.");
        createBill(company,newOrder,product.getPrice());


    }

    private void createBill(Company company, Order order,double price){
        Bill bill = new Bill(String.valueOf(billDao.numberOfBills()+1),CustomDateFormatter.formatDateToJune(),company,order,price);
        billService.add(bill);
        System.out.println("Fatura başarıyla oluşturulmuştur");
        writeMainMenu();
    }

    private void filterCustomersAccordingToName(String character){
        System.out.println("İçinde C harfi olan kullanıcılar");
        List<Customer> customerList = customerService.getCustomersFilterAccordingToName(character);
        for (Customer customer:customerList){
            System.out.println(customer);
        }
    }

    private void totalBillAmountOfCustomerThatRegisterInJune(){
        System.out.println("Haziran ayında kayıt olan kullanıcıların toplam fatura tutarı: "+billService.totalBillAmountOfCustomerThatRegisterInJune());
    }

    private void listOfBills(){
        System.out.println("Tüm faturalar");
        billService.getAll().stream().forEach(System.out::println);
    }

    private void billThatPriceIsOverOneThousandFiveHundred(){
        System.out.println("1500TL Üzerindeki faturalar");
        billService.billThatPriceIsOverOneThousandFiveHundred().stream().forEach(System.out::println);
    }

    private void averageBillThatPriceIsOverOneThousandFiveHundred(){
        System.out.println("1500TL üzerindeki faturaların ortalaması "+billService.averageBillThatPriceIsOverOneThousandFiveHundred());
    }

    private void customerThatHaveUnderFiveHundredAmountBill(){
        billService.customerThatHaveUnderFiveHundredAmountBill().stream().forEach(System.out::println);
    }





    private void chooseProcess(int number)
    {
        switch (number){
            case 1:
                addCustomer();
                break;
            case 2:
                getCustomers();
                break;
            case 3:
                chooseCompany();
                break;
            case 4:
                filterCustomersAccordingToName("C");
                break;
            case 5:
                totalBillAmountOfCustomerThatRegisterInJune();
                break;
            case 6:
                listOfBills();
                break;
            case 7:
                billThatPriceIsOverOneThousandFiveHundred();
                break;
            case 8:
                averageBillThatPriceIsOverOneThousandFiveHundred();
                break;
            case 9:
                customerThatHaveUnderFiveHundredAmountBill();
                break;


        }

    }



}
