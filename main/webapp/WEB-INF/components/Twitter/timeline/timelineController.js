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

        var tweetAction = component.get("c.getAllTweets");
        tweetAction.setCallback(this, function(a) {
                // Container for tweet objects from database
                var dbTweets = [];
                dbTweets = a.getReturnValue();
                
                var history = component.get("v.history");
                for (var i = 0; i < dbTweets.length; i++) {
                    var newTweet = {
                     "name": dbTweets[i].username,
                     "message": dbTweets[i].message,
                     "date": dbTweets[i].date,
                     "imgpath": dbTweets[i].imgPath
                    };
                    console.log(newTweet.name);
                    history.push(newTweet);
                }

                history = history.reverse();
                component.set("v.history", history);
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
             "imagepath": event.getParam("imgpath")
         };

        var history = component.get("v.history");
        // Reverse so the tweets are in time order
        history = history.reverse();

        history.push(newTweet);
        history = history.reverse();
        component.set("v.history", history);

        for (i=0; i < history.length; i++) {
            console.log("History[" + i + "] = " + JSON.stringify(history[i]));
        }
     }
})