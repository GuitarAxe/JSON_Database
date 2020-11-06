package server;

import com.beust.jcommander.Parameter;

public class Arguments {
    @Parameter(names = "-t", description = "Type of request")
    public String type = "exit";

    @Parameter(names = "-k", description = "Key for the value")
    public String key = "";

    @Parameter(names = "-v", description = "Value to save in database in set request")
    public String input = "";


}
