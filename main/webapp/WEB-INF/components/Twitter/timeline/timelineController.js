({
    receiveTweet : function(component, event, helper) {
        // Logs a message to the console
        /*
         console.log("Received a message: " + JSON.stringify(event));
         console.log("Message is: " + event.getParam("text"));
         component.set("v.number", event.getParam("text"));
        */
         var newTweet = {
             "name": event.getParam("name"),
             "message": event.getParam("message"),
             "date": event.getParam("date"),
             "imageUrl": event.getParam("imageUrl")
         };

        var history = component.get("v.history");
        history.push(newTweet);
        component.set("v.history", history);

        for (i=0; i < history.length; i++) {
            console.log("History[" + i + "] = " + JSON.stringify(history[i]));
        }
     }
})