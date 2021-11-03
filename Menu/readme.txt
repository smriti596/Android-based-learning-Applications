A simple app designed to practice working with Logs.
Here, we will read data from each of the menu item TextViews and to print the value of each menu item to the logs.

We are doing the three steps three times:
 Step 1: Get the TextView with findViewById.
 Step 2: Use the getter called getText to get the text. Another method called toString must be used to convert the result (which is a CharSequence) returned from getText into a String. 
 Step 3: Then use the method Log.v to print the log. You could have used any of the Logging methods to print the log, we chose verbose.
