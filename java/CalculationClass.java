
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ming
 */
public class CalculationClass {

    /**
     *
     */
    protected int Total_CashOwned;

    /**
     *
     */
    protected int launchRound;

    /**
     *
     */
    protected double launch_Bonus;

    /**
     *
     */
    protected int all_tech_costReduction;

    /**
     *
     */
    protected int data_costReduction;

    /**
     *
     */
    protected int spentOnTech;

    /**
     *
     */
    protected int spentOn_MarketResearch;

    /**
     *
     */
    protected int spentOn_Promotion;

    /**
     *
     */
    protected int cash_bonus;

    /**
     *
     */
    protected int cash_earned;

    /**
     *
     */
    protected int net_Cash;

    /**
     *
     */
    protected int promotion_bonus;

    /**
     *
     */
    protected int tech_userBonus;

    /**
     *
     */
    protected int complexity_penalty;

    /**
     *
     */
    protected int new_User;

    /**
     *
     */
    protected int CASH;

    /**
     *
     */
    protected int round,

    /**
     *
     */
    cash,

    /**
     *
     */
    users,

    /**
     *
     */
    hardware,

    /**
     *
     */
    integration,

    /**
     *
     */
    multiuser,

    /**
     *
     */
    navigation,

    /**
     *
     */
    notifications,

    /**
     *
     */
    search,

    /**
     *
     */
    userInterface,

    /**
     *
     */
    analytics,

    /**
     *
     */
    location,

    /**
     *
     */
    marketplace,

    /**
     *
     */
    media,

    /**
     *
     */
    social,

    /**
     *
     */
    storage,

    /**
     *
     */
    sync,

    /**
     *
     */
    code,

    /**
     *
     */
    analytics_server,

    /**
     *
     */
    applicationServer,

    /**
     *
     */
    databaseServer,

    /**
     *
     */
    externalApi,

    /**
     *
     */
    privacy,

    /**
     *
     */
    security;

    /**
     *
     */
    protected int action;

    ConnectionClass connection = new ConnectionClass();

    CalculationClass() { // default constructor
        launchRound = 0;
        launch_Bonus = 0;
        all_tech_costReduction = 0;
        data_costReduction = 0;
        spentOnTech = 0;
        spentOn_MarketResearch = 0;
        spentOn_Promotion = 0;
        cash_bonus = 0;
        cash_earned = 0;
        net_Cash = 0;
        promotion_bonus = 0;
        tech_userBonus = 0;
        complexity_penalty = 0;
        new_User = 0;
    }

    /**
     *
     * @param action
     */
    protected void setAction(int action) {
        this.action = action;
    }

    /**
     *
     * @return
     */
    protected int getAction() {
        return action;
    }

    //

    /**
     *
     * @param n
     */
    protected void Setter(String n) {
        int[] array = new int[25];
        connection.ConnectToDB();
        if (connection.IsConnected()) {
            array = connection.StoreNumbersOfCards(n);
        }
        round = array[0];
        cash = array[1];
        users = array[2];
        hardware = array[3];
        integration = array[4];
        multiuser = array[5];
        navigation = array[6];
        notifications = array[7];
        search = array[8];
        userInterface = array[9];
        analytics = array[10];
        location = array[11];
        marketplace = array[12];
        media = array[13];
        social = array[14];
        storage = array[15];
        sync = array[16];
        code = array[17];
        analytics_server = array[18];
        applicationServer = array[19];
        databaseServer = array[20];
        externalApi = array[21];
        privacy = array[22];
        security = array[23];
    }

    /**
     *
     * @param n
     * @return
     */
    protected int LAUNCH(String n) {
        ConnectionClass conn = new ConnectionClass();
        conn.ConnectToDB();
        int launch = conn.returnLaunchNumber(n); //return number 1 here
        if (launch == 1) {
            launchRound = 1;
        }
        return launchRound;
    }

    //

    /**
     *
     * @param n
     * @return
     */
    protected double LaunchBonus(String n) {
        ConnectionClass conn = new ConnectionClass();
        conn.ConnectToDB();
        launch_Bonus = conn.returnBonus(n, "launchBonus");//return number 100 here
        return launch_Bonus;
    }
    // Return Tech cost reduction

    /**
     *
     * @param n
     * @return
     */
    protected int AllTechCostReduction(String n) {
        Setter(n);
        switch (code) {
            case 2:
                all_tech_costReduction = 100;
                break;
            case 3:
                all_tech_costReduction = -100;
                break;
            default:
                all_tech_costReduction = 0;
                break;
        }
        return all_tech_costReduction;
    }

    // return data cost reduction

    /**
     *
     * @param n
     * @return
     */
    protected int DataCostReduction(String n) {
        Setter(n);
        if (applicationServer == 2 || databaseServer == 2) {
            data_costReduction = 100;
        } else if (applicationServer == 3 || databaseServer == 3) {
            data_costReduction = 200;
        } else if (applicationServer == 2 && databaseServer == 2) {
            data_costReduction = 200;
        } else if ((applicationServer == 2 && databaseServer == 3) || (applicationServer == 3 && databaseServer == 2)) {
            data_costReduction = 300;
        } else if (applicationServer == 3 && databaseServer == 3) {
            data_costReduction = 400;
        } else {
            data_costReduction = 0;
        }
        return data_costReduction;
    }

    //

    /**
     *
     * @param n
     * @param action
     * @return
     */
    protected int SpentOnTechnology(String n, String action) {
        Setter(n);
        if (action.equals("userInterface")) {
            spentOnTech = spentOnTech + (200 - AllTechCostReduction(n));
        } else if (action.equals("navigation")) {
            spentOnTech = spentOnTech + (300 - AllTechCostReduction(n));
        } else if (action.equals("notifications")) {
            spentOnTech = spentOnTech + (400 - AllTechCostReduction(n));
        } else if (action.equals("search")) {
            spentOnTech = spentOnTech + (600 - AllTechCostReduction(n));
        } else if (action.equals("hardware")) {
            spentOnTech = spentOnTech + (800 - AllTechCostReduction(n));
        } else if (action.equals("integration")) {
            spentOnTech = spentOnTech + (1000 - AllTechCostReduction(n));
        } else if (action.equals("multiuser")) {
            spentOnTech = spentOnTech + (1500 - AllTechCostReduction(n));
        } else if (action.equals("social")) {
            spentOnTech = spentOnTech + (200 - AllTechCostReduction(n));
        } else if (action.equals("location")) {
            spentOnTech = spentOnTech + (300 - AllTechCostReduction(n));
        } else if (action.equals("media")) {
            spentOnTech = spentOnTech + (400 - AllTechCostReduction(n));
        } else if (action.equals("sync")) {
            spentOnTech = spentOnTech + (600 - AllTechCostReduction(n));
        } else if (action.equals("storage")) {
            spentOnTech = spentOnTech + (800 - AllTechCostReduction(n));
        } else if (action.equals("marketplace")) {
            spentOnTech = spentOnTech + (1000 - AllTechCostReduction(n));
        } else if (action.equals("analytics")) {
            spentOnTech = spentOnTech + (1500 - AllTechCostReduction(n));
        } else if (action.equals("code")) {
            spentOnTech = spentOnTech + (200 - AllTechCostReduction(n) - DataCostReduction(n));
        } else if (action.equals("applicationServer")) {
            spentOnTech = spentOnTech + (300 - AllTechCostReduction(n) - DataCostReduction(n));
        } else if (action.equals("databaseServer")) {
            spentOnTech = spentOnTech + (400 - AllTechCostReduction(n) - DataCostReduction(n));
        } else if (action.equals("externalApi")) {
            spentOnTech = spentOnTech + (600 - AllTechCostReduction(n) - DataCostReduction(n));
        } else if (action.equals("privacy")) {
            spentOnTech = spentOnTech + (800 - AllTechCostReduction(n) - DataCostReduction(n));
        } else if (action.equals("analytics_server")) {
            spentOnTech = spentOnTech + (1000 - AllTechCostReduction(n) - DataCostReduction(n));
        } else if (action.equals("security")) {
            spentOnTech = spentOnTech + (1500 - AllTechCostReduction(n) - DataCostReduction(n));
        }

        if (cash >= spentOnTech) {
            return cash - spentOnTech;
        } else {
            return cash;
        }
    }
    //

    /**
     *
     * @param n
     * @return
     */
    protected int SpentOnMarketResearch(String n) {
        Setter(n);
        spentOn_MarketResearch = 300;
        return cash - spentOn_MarketResearch;
    }
    //

//    protected int SpentOnPromotion(String n) {
//        Setter(n);
//        spentOn_Promotion = 1000;
//        return cash - spentOn_Promotion;
//    }
    //

    /**
     *
     * @return
     */
    protected int CashBonusThisRound() {

        return cash_bonus;
    }

    //

    /**
     *
     * @param n
     * @return
     */
    protected int NetCashThisRound(String n) {
        net_Cash = CashEarnedThisRound(n)
                - (spentOnTech + spentOn_MarketResearch + spentOn_Promotion);
        return net_Cash;
    }
    //

    /**
     *
     * @param n
     * @return
     */
    protected int PromotionUsersBonusThisRound(String n) {
        ConnectionClass conn = new ConnectionClass();
        conn.ConnectToDB();

        promotion_bonus = conn.returnBonus(n, "totalBonusFromPromotion");
        return promotion_bonus;
    }
    //

    /**
     *
     * @return
     */
    protected int TechUserBonusThisRound() {
        if (analytics == 2) {
            tech_userBonus += 5;
        }
        if (analytics == 3) {
            tech_userBonus += 10;
        }
        if (externalApi == 2) {
            tech_userBonus += 10;
        }
        if (externalApi == 3) {
            tech_userBonus += 20;
        }
        if (privacy == 2) {
            tech_userBonus += 10;
        }
        if (privacy == 3) {
            tech_userBonus += 20;
        }
        if (analytics_server == 2) {
            tech_userBonus += 10;
        }
        if (analytics_server == 3) {
            tech_userBonus += 20;
        }
        if (security == 2) {
            tech_userBonus += 10;
        }
        if (security == 3) {
            tech_userBonus += 20;
        } else {
            tech_userBonus += 0;
        }
        return tech_userBonus;
    }

    //

    /**
     *
     * @return
     */
    protected int ComplexityPenalty() {

        return complexity_penalty;
    }
    //

    /**
     *
     * @param n
     * @return
     */
    protected int SumAO(String n) {
        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();
        int[] array = connection.StoreNumbersOfCards(n);
        Setter(n);
        int sum = 0;
        for (int i = 3; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //

    /**
     *
     * @param n
     * @return
     */
    protected int CashEarnedThisRound(String n) {
        Setter(n);
        if (LAUNCH(n) != 0) { // if game is launched
            cash_earned = (1 + CashBonusThisRound() / 100) * LAUNCH(n)
                    * NewUsersThisRound(n);
        } else {
            cash_earned = 0;
        }
        return cash_earned + cash;
    }

    //

    /**
     *
     * @param n
     * @return
     */
    protected int GetW42(String n) {
        int[] array = new int[25];
        int sum = 0;
        connection.ConnectToDB();
        if (connection.IsConnected()) {
            array = connection.StoreNumbersOfCards(n);
        }

        for (int i = 3; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //

    /**
     *
     * @param n
     * @return
     */
    protected int NewUsersThisRound(String n) {
        new_User = (int) (GetW42(n) * (1 + (double) ((1 + PromotionUsersBonusThisRound(n) / 100)
                + (TechUserBonusThisRound() / 100)
                + (ComplexityPenalty() / 100))) * LAUNCH(n) * (double) (1 + LaunchBonus(n) / 100) * 1000);
        return new_User;
    }

    /**
     *
     * @param act
     * @param n
     * @return
     */
    public boolean isAbleToPurchase(String act, String n) {
        Setter(n);
        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();
        int total_bonus = 0;
        boolean ispossible = false;
        //front end
        if (act.equals("userInterface") && userInterface <= 2) { // 1
            if (userInterface == 0) {
                ispossible = true;
            } else if (userInterface == 1) {
                ispossible = true;
            } else if (userInterface == 2 && hardware == 1) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("navigation") && navigation <= 2) {  //2
            if (navigation == 0) {
                ispossible = true;
            } else if (navigation == 1 && hardware == 1) {
                ispossible = true;
            } else if (navigation == 2 && search == 1) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("notifications") && notifications <= 2) {//3
            if (notifications == 0) {
                ispossible = true;
            } else if (notifications == 1 && integration == 1) {
                ispossible = true;
            } else if (notifications == 2 && social == 1) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("search") && search <= 2) { //4
            if (search == 0) {
                ispossible = true;
            } else if (search == 1 && integration == 1) {
                ispossible = true;
            } else if (search == 2 && databaseServer == 1) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("hardware") && hardware <= 2) { // 5
            if (hardware == 0) {
                ispossible = true;
            } else if (hardware == 1 && integration == 1) {
                ispossible = true;
            } else if (hardware == 2 && integration == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("integration") && integration <= 2) {//6
            if (integration == 0) {
                ispossible = true;
            } else if (integration == 1 && externalApi == 1) {
                ispossible = true;
            } else if (integration == 2 && code == 2 && externalApi == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("multiuser") && multiuser <= 2) { //7
            if (multiuser == 0) {
                ispossible = true;
            } else if (multiuser == 1 && integration == 1 && notifications == 1) {
                ispossible = true;
            } else if (multiuser == 2 && integration == 2 && applicationServer == 2 && databaseServer == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } // infastructure
        else if (act.equals("applicationServer") && applicationServer <= 2) { // 1
            ispossible = true;
        } else if (act.equals("databaseServer") && databaseServer <= 2) { // 2
            if (databaseServer == 0) {
                ispossible = true;
            } else if (databaseServer == 1 && applicationServer == 2) {
                ispossible = true;
            } else if (databaseServer == 2 && code == 3) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("externalApi") && externalApi <= 2) { // 3 has user bonus
            if (externalApi == 0) {
                ispossible = true;
            } else if (externalApi == 1 && code == 2) {
                ispossible = true;
                total_bonus = 10 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            } else if (externalApi == 2 && code == 3) {
                ispossible = true;
                total_bonus = 20 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            }
        } else if (act.equals("privacy") && privacy <= 2) { // 4 has user bonus
            if (privacy == 0) {
                ispossible = true;
            } else if (privacy == 1) {
                ispossible = true;
                total_bonus = 10 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            }
            if (privacy == 2 && applicationServer == 2 && databaseServer == 2) {
                ispossible = true;
                total_bonus = 20 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            }
        } else if (act.equals("analytics_server") && analytics_server <= 2) {// 5 has user bonus
            if (analytics_server == 0) {
                ispossible = true;
            } else if (analytics_server == 1 && applicationServer == 2 && databaseServer == 2) {
                ispossible = true;
                total_bonus = 10 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            } else if (analytics_server == 2 && applicationServer == 3 && databaseServer == 3) {
                ispossible = true;
                total_bonus = 20 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            } else {
                ispossible = false;
            }
        } else if (act.equals("security") && security <= 2) { // 6 has user bonus
            if (security == 0) {
                ispossible = true;
            } else if (security == 1 && applicationServer == 2 && databaseServer == 2) {
                ispossible = true;
                total_bonus = 10 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            } else if (security == 2 && applicationServer == 3 && applicationServer == 3) {
                ispossible = true;
                total_bonus = 20 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            } else {
                ispossible = false;
            }
        } else if (act.equals("code") && code <= 2) { // 7
            if (code == 0) {
                ispossible = true;
            } else if (code == 1) {
                ispossible = true;
            } else if (code == 2 && applicationServer == 2 && databaseServer == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } //webservices
        else if (act.equals("media") && media <= 2) { // 1
            if (media == 0) {
                ispossible = true;
            } else if (media == 1 && hardware == 1 && integration == 1) {
                ispossible = true;
            }
            if (media == 2 && hardware == 2 && integration == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("marketplace") && marketplace <= 2) { // 2
            if (marketplace == 0) {
                ispossible = true;
            } else if (marketplace == 1 && integration == 1) {
                ispossible = true;
            } else if (marketplace == 2 && code == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("storage") && storage <= 2) {//3
            if (storage == 0) {
                ispossible = true;
            } else if (storage == 1 && integration == 1) {
                ispossible = true;
            } else if (storage == 2 && code == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("sync") && sync <= 2) { //4
            if (sync == 0) {
                ispossible = true;
            } else if (sync == 1 && integration == 1) {
                ispossible = true;
            } else if (sync == 2 && integration == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("analytics") && analytics <= 2) { //5 user bon
            if (analytics == 0) {
                ispossible = true;
            } else if (analytics == 1 && code == 2) {
                ispossible = true;
                total_bonus = 5 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            } else if (analytics == 2 && applicationServer == 1 && databaseServer == 1) {
                ispossible = true;
                total_bonus = 10 + connection.returnBonus(n, "totalBonusFromPromotion");
                connection.updatePromotionBouns(total_bonus, n);
            } else {
                ispossible = false;
            }
        } else if (act.equals("social") && social <= 2) { // 6
            if (social == 0) {
                ispossible = true;
            } else if (social == 1 && integration == 1) {
                ispossible = true;
            } else if (social == 2 && integration == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        } else if (act.equals("location") && location <= 2) {//7
            if (location == 0) {
                ispossible = true;
            } else if (location == 1 && hardware == 1 && integration == 1) {
                ispossible = true;
            } else if (location == 2 && integration == 2) {
                ispossible = true;
            } else {
                ispossible = false;
            }
        }
        return ispossible;
    }
}
