({
    tweet : function(component, event, helper) {

        var message = component.find("tweetInput").get("v.value");
        
        var output = component.find("tweetOutput");
        output.set("v.value", message);

   		//var tweetEvent = $A.get("e.Twitter:tweet");
   		//tweetEvent.fire();
    }
})