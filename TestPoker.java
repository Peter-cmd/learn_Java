package Test.Poker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//牌类
class Card{
    public String rank;
    public String suit;

    @Override
    public String toString(){
        return String.format("[%s %s]",suit,rank);
    }
}

public class TestPoker {
    //存储花色
    private static final String[] SUITS = {"♣","♦","♠","♥"};
    //存储牌面值
    private static final String[] RANKS = {" ","A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    //买一副牌
    private static List<Card> aDeckOfPoker(){
        //创建52张牌
        List<Card> poker = new ArrayList<>(52);
        //循环创建各花色和各牌面的牌
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= 13; j++){
                Card card = new Card();
                card.suit = SUITS[i];
                card.rank = RANKS[j];
                poker.add(card);  //将创建的牌加入牌堆
            }
        }
        return poker;  //返回整副牌
    }

    //洗牌打乱牌序
    //交换两张牌的顺序
    private static void swap(List<Card> poker, int i , int j){
        Card card = poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,card);
    }

    //获取随机值,交换牌序
    private static void shuffle(List<Card> poker){
        Random random = new Random(20191110);
        for (int i = poker.size() - 1; i > 0 ; i--){
            int r = random.nextInt(i);
            swap(poker,i,r);
        }
    }

    public static void main(String[] args){
        List<Card> poker = aDeckOfPoker();  //创建一副牌
        System.out.println(poker);
        shuffle(poker);  //洗牌
        System.out.println(poker);

        //三个人轮流抓牌
        List<List<Card>> hands = new ArrayList<>();
        hands.add(new ArrayList<Card>());
        hands.add(new ArrayList<Card>());
        hands.add(new ArrayList<Card>());
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                hands.get(j).add(poker.remove(0));
            }
        }

        //打印输出牌堆和手牌的情况
        System.out.println("剩余的牌:");
        System.out.println(poker);
        System.out.println("第一个人的手牌为:");
        System.out.println(hands.get(0));
        System.out.println("第二个人的手牌为:");
        System.out.println(hands.get(1));
        System.out.println("第三个人的手牌为:");
        System.out.println(hands.get(2));
    }
}
