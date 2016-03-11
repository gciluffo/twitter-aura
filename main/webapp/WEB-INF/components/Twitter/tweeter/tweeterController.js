({
    sendTweet : function(component, event, helper) {
        
        var message = component.find("tweetInput").get("v.value");
        
        // display the tweet
        var tweetEvent = $A.get("e.Twitter:tweet");
        tweetEvent.setParams({
            "name": "gciluffo",
            "date": new Date(),
            "message": message,
            "imagesrc": "/img/defualtprofilepic.png"
        });

        // If the message is not empty and is less than 150 characters long
        if(message && message.length <= 150) {
            tweetEvent.fire();
            
            
            // Then add the tweet to the database
            var action = component.get("c.insertTweet");
            action.setParams({
                message: message,
                date: new Date().toString(),
                username: "gciluffo",
                imgPath: "/home/pictures"
            });
            action.setCallback(this, function(response) {
                if (response.getState() === "SUCCESS") {
                    console.log("Server responded");
                }
                else {
                    console.log("Nope");
                }
            });

            $A.enqueueAction(action);
            component.set("v.inputText", "");
        }
    }
})