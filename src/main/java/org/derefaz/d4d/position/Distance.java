package org.derefaz.d4d.position;

public class Distance {

	
	public static double calculate(Double lat1, Double lng1, Double lat2, Double lng2){
		//D=SQR((X2-X1)^2+(Y2-Y1)^2)
		Double latDiff 	= lat2-lat1;
		Double lngDiff 	= lng2-lng1;
		Double latPow 	= Math.pow(latDiff, 2);
		Double lngPow 	= Math.pow(lngDiff, 2);
		Double distance = Math.sqrt(latPow+lngPow);
		return distance;
	}
}
