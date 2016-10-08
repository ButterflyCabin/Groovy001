package Java;

/**
 * Desc:
 * Author: Yehu
 * Created by kachesiji on 2016/6/22.
 */
public class Testdemo1 {
    public static void main(String[] args){
        Book book = new Book("Android ",499,79.88);
        showBook(book);
    }

    public static void showBook(Book book){
        if(null !=book){
            System.out.println("书名："+book.getName()+"\n页数："+book.getPage()+"\n价格："+book.getPrice());
        }
    }

    /**
     * class 封装参数
     */
    static class Book{
        private double price ; // 价钱
        private int page ;// 页数
        private String name;// 书名

        public Book(String name,int page,double price){
            this.page = page;
            this.price = price;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
