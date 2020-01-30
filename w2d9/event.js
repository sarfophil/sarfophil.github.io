/**
 * Customized Event Based Module
 * which sends callback to observers when events are triggered
 * @author SARFO OWUSU PHILIP
 */
let event = (function() {

    "use strict"

    /**
     * Event Creation Object
     */
    function Event() {
        this.subject = function() {
            // List of observers
            let observers = []



            /** Adds an observer to the array */
            function addObserver(Observer) {
                observers.push(Observer)
            }


            /** Removes an observer from array */
            function detachObserver(Observer) {
                let index = observers.indexOf(Observer)
                observers.splice(index, 1)
            }

            /** Invokes observers from list by call their methods */
            function update(topic) {
                let topics = observers.filter((observer) => {
                    return observer.getEventName() === topic
                })
                topics.forEach(topic => {
                    topic.getAction().call()
                })
            }

            return {
                'addObserver': addObserver,
                'detachObserver': detachObserver,
                'notify': update,
                'observers': function() {
                    return observers
                }
            }

        }()


        function memory() {
            let cache = LocalStorage.getItem('EVENT_STORAGE')

            const init = function() {
                if (!cache) {
                    cache = LocalStorage.setItem('EVENT_STORAGE', [])
                }
            }

            const save = function(data) {
                LocalStorage.setItem('EVENT_STORAGE', data)
            }

            return {
                update: function() {
                    init()
                    save()
                }

            }

        }

        /**
         * Listens to a topic for event changes
         * @param {String} event 
         * @param {Function} action 
         */
        this.subscribe = function(event, action) {
            const observer = new Observer(event, action)
            this.subject.addObserver(observer)
        }

        /**
         * Attaches topic to the list of subjects
         * @param {String} topic 
         */
        this.publish = function(topic) {
            this.subject.notify(topic)
        }


    }





    /**
     * Object for observer creation
     * @param {String} event Name of the event
     * @param {Function} action Function to be invoked
     */
    function Observer(event, action) {
        this.event = event
        this.action = action

        return {
            getEventName: () => {
                return this.event
            },
            getAction: () => {
                return this.action
            }
        }
    }

    return new Event();
})()