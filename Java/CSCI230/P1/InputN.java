package P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputN {
    //Gets input from user. Returns input as int n.
    public int getInput() {
        System.out.print("Enter number of integers to be located: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = null;
        try {
            n = br.readLine();
        }
        catch (IOException e) {}
        return  Integer.parseInt(n);
    }
    
}
