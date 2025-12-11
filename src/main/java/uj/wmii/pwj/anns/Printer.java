package uj.wmii.pwj.anns;

public class Printer {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static void printLogo(){
        System.out.println("░▒▓████████▓▒░▒▓████████▓▒░░▒▓███████▓▒░▒▓████████▓▒░      ░▒▓████████▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓████████▓▒░ ");
        System.out.println("   ░▒▓█▓▒░   ░▒▓█▓▒░      ░▒▓█▓▒░         ░▒▓█▓▒░          ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░");
        System.out.println("   ░▒▓█▓▒░   ░▒▓█▓▒░      ░▒▓█▓▒░         ░▒▓█▓▒░          ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░");
        System.out.println("   ░▒▓█▓▒░   ░▒▓██████▓▒░  ░▒▓██████▓▒░   ░▒▓█▓▒░          ░▒▓██████▓▒░ ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒▒▓███▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓██████▓▒░");
        System.out.println("   ░▒▓█▓▒░   ░▒▓█▓▒░             ░▒▓█▓▒░  ░▒▓█▓▒░          ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░");
        System.out.println("   ░▒▓█▓▒░   ░▒▓█▓▒░             ░▒▓█▓▒░  ░▒▓█▓▒░          ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░");
        System.out.println("   ░▒▓█▓▒░   ░▒▓████████▓▒░▒▓███████▓▒░   ░▒▓█▓▒░          ░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░");
    }
    public static void printSuccess(String testedMethod){
        System.out.println(GREEN + "[ PASS ] " + RESET + "Tested method: " + testedMethod);
    }
    public static void printFail(String testedMethod){
        System.out.println(RED + "[ FAIL ] " + RESET + "Tested method: " + testedMethod);
    }

    public static void summarize(int successCount, int failCount, int errorCount){
        System.out.println("Summary: " + GREEN + successCount + RESET + " passed, " + RED + failCount + RESET + " failed, " + RED + errorCount + RESET + " threw an error.");
    }

}
