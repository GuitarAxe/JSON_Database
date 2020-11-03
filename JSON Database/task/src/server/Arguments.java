package server;

import com.beust.jcommander.Parameter;

public class Arguments {
    @Parameter(names = "-t", description = "Type of request")
    public String type = "exit";

    @Parameter(names = "-i", description = "Index of the cell")
    public int index = -1;

    @Parameter(names = "-m", description = "Value to save in database in set request")
    public String input = "";
}
