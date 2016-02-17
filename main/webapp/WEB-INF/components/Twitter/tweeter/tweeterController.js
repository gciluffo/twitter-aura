({
    sendTweet : function(component, event, helper) {
        console.log("Sending tweet");

        var message = component.find("tweetInput").get("v.value");

        var tweetEvent = $A.get("e.Twitter:tweet");
        tweetEvent.setParams({
            "name": "Griffin",
            "date": new Date(),
            "message": message,
            "imageUrl": "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
        });
        tweetEvent.fire();
        component.set("v.inputText", "");
    }
})