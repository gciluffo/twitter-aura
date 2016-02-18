({
    sendTweet : function(component, event, helper) {
        console.log("Sending tweet");

        var message = component.find("tweetInput").get("v.value");

        var tweetEvent = $A.get("e.Twitter:tweet");
        tweetEvent.setParams({
            "name": "Griffin",
            "date": new Date(),
            "message": message,
            "imagesrc": "/img/defualtprofilepic.png"
        });

        // If the message is empty
        if(message){
            tweetEvent.fire();
        }
        component.set("v.inputText", "");
    }
})