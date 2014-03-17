package com.straightbeast.realbigd.rets.readers;

import org.realtors.rets.client.SearchResultImpl;
import org.springframework.batch.item.ItemReader;

public class GreenvilleReader implements ItemReader<String> {
	
	private static final int MAX_OUTER = 0;

	private String[] input = { "Hello", "world!", "Wow", "that's", "cool!" };

	private int index = 0;

	private int outer = 0;

	/**
	 * Reads next record from input
	 */
	 public synchronized String read() throws Exception {
		 String response = null;
		 
		if (index >= input.length) {
			outer++;
			if (outer > MAX_OUTER) {
				return null;
			} else {
				index = 0;
			}
		}
		return response;
	}
	
	/*
	public synchronized void read() throws MalformedURLException {

	    //Create a RetsHttpClient (other constructors provide configuration i.e. timeout, gzip capability)
	    RetsHttpClient httpClient = new CommonsHttpClient();
	    RetsVersion retsVersion = RetsVersion.RETS_15;
	    String loginUrl = "http://greenville.rets.fnismls.com/rets/fnisrets.aspx/GREENVILLE/login?rets-version=rets/1.5";

	    //Create a RetsSession with RetsHttpClient
	    RetsSession session = new RetsSession(loginUrl, httpClient, retsVersion);    

	    String username = "elderEnt";
	    String password = "rets_ElderIsa2000141";

	    //Set method as GET or POST
	    session.setMethod("POST");
	    try {
	        //Login
	        session.login(username, password);
	    } catch (RetsException e) {
	        e.printStackTrace();
	    }

	    String sQuery = "(L_StatusCatID=1)";
	    String sResource = "Property";
	    String sClass = "RE_1";

	    //Create a SearchRequest
	    SearchRequest request = new SearchRequest(sResource, sClass, sQuery);

	    //Select only available fields
	    String select ="*";
	    request.setSelect(select);

	    //Set request to retrieve count if desired
	    request.setCountFirst();

	    SearchResultImpl response;
	    try {
	        //Execute the search
	        response = (SearchResultImpl) session.search(request);
	        
	        // For Printing XML (see function below)
	        //printXML(response);
	        
	        //Print out count and columns
	        int count = response.getCount();
	        System.out.println("COUNT: " + count);
	        System.out.println("COLUMNS: " + StringUtils.join(response.getColumns(), "\t"));

	        //Iterate over, print records
	        for (int row = 0; row < response.getRowCount(); row++){
	            //System.out.println("ROW"+ row +": " + StringUtils.join(response.getRow(row), "\t"));
	        }
	    } catch (RetsException e) {
	        e.printStackTrace();
	    } 
	    finally {
	        if(session != null) { 
	            try {
	                session.logout(); 
	            } 
	            catch(RetsException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	*/
}

