class Solution {
    record Car(int position, double time) {}

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];

        for(int i = 0; i < position.length; ++i) {
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }

        Arrays.sort(cars, (a, b) -> b.position() - a.position());

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < cars.length; ++i) {
            if(stack.isEmpty()) stack.push(cars[i].time());
            else if(cars[i].time() > stack.peek()) stack.push(cars[i].time());
        }

        return stack.size();
    }
}

/*
    for each position, compute the number of steps it takes them to 
    reach the destination, given by
        position = (target - position) / speed

    if we sort the array in descending order according to positions
    then car1 is most relevant, and for car2, if the steps it takes for car2
    to reach the destionation is <= to those of car1, then it means that they will 
    arrive in the same fleet
    this goes on for car3 as well, if the steps it takes are >= to those of car2
    it will join the same car fleet as car2
    i will store what car fleet every car is part of in a new array
    at the end i will traverse that array to see how may different
    car fleets i have
    keep a leaderTime value and a fleets counter. Every time you process a car whose 
    time is > leaderTime, that means it can't merge — a new fleet starts, so you:
    (1) increment the counter
    (2) update leaderTime to this car's time. If its time is <= leaderTime, you do 
    nothing (no increment, no update) since it just merges into the existing fleet.
*/