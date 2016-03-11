({
	/** Properties shared across test cases**/
	attributes: {
	label: 'Tweet',
	//Other attributes here
	},
	browsers: ['GOOGLECHROME', 'SAFARI', 'IPAD' ],
	setUp: function(component) {
	//Runs before each test case is executed but after component initialization
	},
	tearDown: function(component) {
	//Runs after each test case is executed
	},
	sharedMethod: function(arg1, arg2) {
	//Utility functions that are invoked by calling this.sharedMethod(x, y)
	},
	/** Test Cases **/
	testCase1: {
		attributes: {
			//Attributes
		},
		//Runs all supported browsers except Firefox.
		//Overrides the suite level browsers tag.
		browsers: [ '-FIREFOX'],
		test: [ //A single function or a list of functions
			function(component){
				// Test that an input longer than 150 chars is not tweeted
				component.set("v.inputText", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				var sendTweetAction = component.get("c.sendTweet");
				$A.test.assertAuraType("Event", sendTweetAction, "Error, event was sent");
			},
			function(component){
				//Test that an empty tweet is not fired
				component.set("v.inputText", "");
				var sendTweetAction = component.get("c.sendTweet");
				$A.test.assertAuraType("Event", sendTweetAction, "Error, event was sent");	
			}
		]
	}
})
