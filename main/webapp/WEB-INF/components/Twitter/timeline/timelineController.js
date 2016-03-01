({ init : function(component, event, helper) {
        
         console.log("init");
        component.set("v.history", [{
            "name": "Matt",
            "date": new Date(),
            "message": "First tweet!",
            "imageUrl": "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
        }]);

        /*
        // Ping the server
        var action = component.get("c.getAppName");
        action.setParams({
            appKey: "TestApp"
        });
        action.setCallback(this, function(response) {
            if (response.getState() === "SUCCESS") {
                console.log("Server responded: " + response.getReturnValue());
            }
            else {
                console.log("Nope");
            }
        });
        $A.enqueueAction(action);
        */

        var tweetAction = component.get("c.getTweets");

        tweetAction.setCallback(this, function(a) {
                var dbTweets = [];
                dbTweets = a.getReturnValue();
            
                console.log("Read " + dbTweets.length + " tweets");
                console.log(dbTweets[0].name);


            
        });
        $A.enqueueAction(tweetAction);
        
    },
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
             "imagesrc": event.getParam("imagesrc")
         };

        var history = component.get("v.history");
        history.push(newTweet);
        // Reverse so the tweets are in time order
        history = history.reverse();
        component.set("v.history", history);

        for (i=0; i < history.length; i++) {
            console.log("History[" + i + "] = " + JSON.stringify(history[i]));
        }
     }
})