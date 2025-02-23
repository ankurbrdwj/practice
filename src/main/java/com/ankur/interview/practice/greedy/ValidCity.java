package com.ankur.interview.practice.greedy;

public class ValidCity {
  /*
  / we have n cities in circle
  each is d distance apart and has fuel station with fuel capacity
  find the city that can be started to cover all
  with miles per gallon = d/fuelCapacity = x
  we have exact total fuel to cover all cities
  trick is city while test traversal has minimum or negative travelcapacity is startigg city

   */
  public int validStartingCity(int[] distance, int[] fuel, int mpg) {
    int travelCapacity = 0; // its mpg*fuel -previousCityDistance;
    int cityIndex = 0;
    int fuelCapacity = 0;
    int travelCapacityAtStart = 0;
    for (int i = 1; i < distance.length; i++) {
      fuelCapacity = mpg * fuel[i - 1];
      travelCapacity += fuelCapacity - distance[i - 1];
      if (travelCapacity < travelCapacityAtStart) {
        travelCapacityAtStart = travelCapacity;
        cityIndex = i;
      }
    }
    return cityIndex;
  }
}
