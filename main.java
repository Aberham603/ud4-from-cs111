/********************************************
*	AUTHORS:	aberham Moreno, Rei Cooper, Zack Preciado
* COLLABORATORS: Google Gemini, ChatGPT, Copilot 
********************************************/

/********************************************
*	TESTER CLASS
*********************************************
*	PROGRAM DESCRIPTION:
*	Tests all methods of the Player class.
*   Tests slots methods
*********************************************/

public class Main 
{
    public static void main(String[] args)
    {
        
        double bet;
        int userChoice;
        boolean keepGoing = true; 
        
        Player aberham = new Player("Aberham", 0, 0, 100); //Zack: name can change
        
        Slots[] wheel = new Slots[3];//lenght of three
        wheel[0] = new Slots("Diamond", 'D', 50);  //Zack
        wheel[1] = new Slots("Seven", '7', 25);  //Zack
        wheel[2] = new Slots("Bell", 'B', 10);  //Zack
        
        RouletteSlot[] table = new RouletteSlot[38]; //Abraham
        table[0] = new RouletteSlot("Green", 0); //Abraham
        for (int i = 1; i < table.length-1; i++) //Abraham
        {
            String color;
            
            if (i % 2 == 0)
            {
                color = "Black";
            }
            else
            {
                color = "Red";
            }
            
            table[i] = new RouletteSlot(color, i);
        }
        table[37] = new RouletteSlot("Green", 0);
        
        System.out.println("Hello! Welcome to Abraham's Big Belly Casino");
        
        do 
        {
            
            System.out.println("Want to play slots or roulette?"); //Abraham
            printMenu();
            userChoice = UtilityBelt.readInt("Your Choice: ", 1, 3);
            
            switch (userChoice)
            {
                case 1:
                    
                    System.out.println("Let's play some Zaktastic slot machines!");
                    
                    do //Abraham
                    {
                        //slots
                        /*
                        print You chose slots!
                        ask How much money they want to bet
                        run the slot machine method
                        if method returns 0 THEN
                            lose bet
                        else
                            give bet back plus money won
                        END
                        
                        ask if they want to play again
                        */
                        
                        bet = UtilityBelt.readDouble("How much do you want to bet? ", 1, aberham.getMoney());
                        
                        double outcome = slotMachine(wheel);
                        
                        if (outcome == 0)
                        {
                            System.out.printf("Womp, womp...%n You lost $%.2f!%n", bet);
                            aberham.setMoney(aberham.getMoney() - bet);
                        }
                        else
                        {
                            aberham.setMoney(aberham.getMoney() + bet + outcome);
                        }
                        
                        System.out.printf("Now you got $%.2f!%n", aberham.getMoney());
                        
                        
                        
                        
                        
                        
                    } while (aberham.getMoney() > 0 && userChoice == 1);
                    break;
                    
                case 2:
                    printTable(); //Zack:Shows ASCII roulette table                     
                    do
                    {
                        int slotNumber;
                        boolean winCondition = false;
                        
                        System.out.println("How do you want to bet?"); //Abraham
                        System.out.println("1: Bet on Black (2:1)"); //Abraham
                        System.out.println("2: Bet on Red (2:1)"); //Abraham
                        System.out.println("3: Bet on 1-12 (3:1)"); //Abraham
                        System.out.println("4: Bet on 13-24 (3:1)"); //Abraham
                        System.out.println("5: Bet on 25-36 (3:1)"); //Abraham
                        System.out.println("6: Bet on a specific number (36:1)"); //Abraham
                        System.out.println("7: Bet on Even (2:1)"); //Zack
                        System.out.println("8: Bet on Odd (2:1)");  //Zack
                        System.out.println("9: Bet on Low (1-18) (2:1)");  //Zack
                        System.out.println("10: Bet on High (19-36) (2:1)");  //Zack
                        
                        userChoice = UtilityBelt.readInt("Your Choice: ", 1, 10);
                        
                        slotNumber = (int)(Math.random() * table.length);
                        
                        
                        bet = UtilityBelt.readDouble("How much do you want to bet? ", 1, aberham.getMoney());
                        
                        
                        if (userChoice == 1 && table[slotNumber].getColor().equals("Black")) //Abraham
                        {
                            aberham.addMoney(bet*2);
                            winCondition = true;
                        }
                        else if (userChoice == 2 && table[slotNumber].getColor().equals("Red")) //Abraham
                        {
                            aberham.addMoney(bet*2);
                            winCondition = true;
                        }
                        else if (userChoice == 3 && table[slotNumber].getNumber() >= 1 && slotNumber <= 12) //Abraham
                        {
                            aberham.addMoney(bet*3);
                            winCondition = true;
                        }
                        else if (userChoice == 4 && table[slotNumber].getNumber() >= 13 && slotNumber <= 24) //Abraham
                        {
                            aberham.addMoney(bet*3);
                            winCondition = true;
                        }
                        else if (userChoice == 5 && table[slotNumber].getNumber() >= 25 && slotNumber <= 36) //Abraham
                        {
                            aberham.addMoney(bet*3);
                            winCondition = true;
                        }
                        else if (userChoice == 6) //Abraham
                        {
                            int number = UtilityBelt.readInt("Which number do you want to bet on? ", 0, table.length);
                                
                            if (table[slotNumber].getNumber() == number)
                            {
                                aberham.addMoney(bet*36);
                                winCondition = true;
                            }
                        }
                        else if (userChoice == 7 && table[slotNumber].getNumber() % 2 == 0 && table[slotNumber].getNumber() != 0)  //Zack
                        {
                            aberham.addMoney(bet*2);
                            winCondition = true;
                        }
                        else if (userChoice == 8 && table[slotNumber].getNumber() % 2 == 1)  //Zack
                        { 
                            aberham.addMoney(bet*2);
                            winCondition = true;
                        }
                        else if (userChoice == 9 && table[slotNumber].getNumber() >= 1 && table[slotNumber].getNumber() <= 18)  //Zack
                        {
                            aberham.addMoney(bet*2);
                            winCondition = true;
                        }
                        else if(userChoice == 10 && table[slotNumber].getNumber() >= 19 && table[slotNumber].getNumber() >= 36)  //Zack
                        {
                            aberham.addMoney(bet*2);
                            winCondition = true;
                        }
                        else
                        {
                            aberham.loseMoney(bet);
                        }
                                
                        if (winCondition)
                        {
                            System.out.printf("Hey, you won! Now you have %.2f dollars!", aberham.getMoney());
                        }
                        else
                        {
                            System.out.printf("Damn, you got rekt. You only have $%.2f left.%n", aberham.getMoney());
                        }
                        
            
                        
                        
                    } while (aberham.getMoney() > 0 && userChoice == 2); //Abraham
                    break;
                    
                case 3:
                    
                    keepGoing = false;
                    break;
            }
            
            if (aberham.getMoney() <= 0)
            {
                System.out.println("No money?? Get out of here!");
            }
            
        } while(keepGoing == true && aberham.getMoney() > 0);
        
        
        
    }
    
    public static double slotMachine(Slots[] wheel) // Zack
    {
        int icon;
        double winningAmount;
       
       
        int[] result = new int[wheel.length];
        
        for (int i = 0; i < result.length; i++) 
        {
            int randIndex = (int)(Math.random() * wheel.length);
            result[i] = randIndex;
        }
        
        
        char a = wheel[result[0]].getIcon(); 
        char b = wheel[result[1]].getIcon(); 
        char c = wheel[result[2]].getIcon(); 
        
        System.out.printf("%c | %c | %c%n", a, b, c);
        
        if (a == b && b == c) 
        {
            winningAmount = wheel[result[1]].getValue(); 
            System.out.printf("🎉 JACKPOT! 3 of a kind! +$%.2f%n", winningAmount);
        } 
        else 
        {
            winningAmount = 0;
            System.out.println("❌ No match. Better luck next time!");
        }
        
        return winningAmount; //must return as int
        
    }
        
    public static void printMenu() //abraham
    {
        System.out.println("1: Slots");
        System.out.println("2: Roulette");
        System.out.println("3: Exit Casino");
    }
    
    public static void printTable()//Zack: Had copilot create the art. Personally added the color
    {
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t=========================================");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t|               ROULETTE                |");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t=========================================");
        System.out.println(ColorCode.TEXT_RED_BOLD + "\t| RED LINE:                             |");
        System.out.println(ColorCode.TEXT_RED_BOLD + "\t|  1(R)  3(R)  5(R)  7(R)  9(R) 11(R)   |");
        System.out.println(ColorCode.TEXT_RED_BOLD + "\t| 13(R) 15(R) 17(R) 19(R) 21(R) 23(R)   |");
        System.out.println(ColorCode.TEXT_RED_BOLD + "\t| 25(R) 27(R) 29(R) 31(R) 33(R) 35(R)   |");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t-----------------------------------------");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t| BLACK LINE:                           |");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t|  2(B)  4(B)  6(B)  8(B) 10(B) 12(B)   |");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t| 14(B) 16(B) 18(B) 20(B) 22(B) 24(B)   |");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t| 26(B) 28(B) 30(B) 32(B) 34(B) 36(B)   |");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t-----------------------------------------");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t|   EVEN   |   ODD   |   1-18   | 19-36 |");
        System.out.println(ColorCode.TEXT_BLACK_BOLD + "\t=========================================");
    }
    
   


}
