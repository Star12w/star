import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class CHOP1 {




    //该类是完成零钱通的各个功能的类


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        double money = 0;
        double balance = 0;
        boolean loop = true;
        String detail  = "=========零钱通明细========";
        String key ="";
        Date date = new Date();
        Scanner scanner = new Scanner(System.in);

        //先完成显示菜单
        public void menu(){

            do{
                System.out.println("============零钱通菜单===========");
                System.out.println("\t\t1、 零钱通明细");
                System.out.println("\t\t2、 收益入账");
                System.out.println("\t\t3、 消费");
                System.out.println("\t\t4、 退     出");

                System.out.println("请选择（1-4）：");

                key = scanner.next();

                //使用switch分支控制
                switch (key){
                    case "1":
                        this.detail();
                        break;
                    case "2":
                        this.income();
                        break;
                    case "3":
                        this.pay();
                        break;
                    case "4":
                        this.exit();
                        break;
                    default:
                        System.out.println("选择有误，请重新选择");
                }


            }while(loop);
        }
        //零钱通明细
        public void detail(){
            System.out.println(detail);
        }
        //收益入账
        public void income(){

            System.out.println("收益入账金额：");
            money = scanner.nextDouble();

            if(money <= 0){
                System.out.println("输入的金额不正确...");
                return;
            }

            balance += money;

            date = new Date();

            detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" +balance;

        }
        //消费
        public void pay(){

            String note = "";
            System.out.println("消费金额：");
            money = scanner.nextDouble();

            if( money <= 0 || money > balance){
                System.out.println("您已超出账户金额");
                return;
            }
            System.out.println("消费说明");
            note = scanner.next();

            balance -= money ;

            detail += "\n+"+ note + "\t-"+ money + "\t" + sdf.format(date) + "\t" +balance;

        }
        //退出
        public void exit(){

            String choice = "";
            while(true){
                System.out.println("你确定要退出码？ y/n");
                choice = scanner.next();
                if (choice.equals("y") || choice.equals("n")){
                    break;
                }

            }
            if(choice.equals("y")){
                loop = false;
            }
        }
    public static void main(String[] args) {
        CHOP1 sso  = new CHOP1();
        sso.menu();

    }

}
