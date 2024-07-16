/*
 * 1. Tracks in Hackathon
 * There is a hackathon organized by HackerRank which has 2 separate tracks, healthcare and e-commerce. 
 * For track 1, the required team size is teamSize_1, while for track 2, the required team size is 
 * teamSize_2. The total number of participants is p.
 * Find the minimum number of teams into which the participants can be divided such that each 
 * participant belongs to exactly one team (either of track 1 or track 2k and each team has a size 
 * equal to either teamSize 1 or teamSize 2. If no such division is possible, return -1.
 * Example
 * Consider teamSize 1- 3, teamSize 2- 4 and number of participants p-7.
 * Optimally there is 1 team of 3 and 1 team of 4. The minimum number of teams is 2.
 * Function Description
 * Complete the function count Teams in the editor below.
 * The function count Teams has the following parameters:
 * int teamSize, 1: the number of participants in teams of track 1. int teamSize 2: the number of 
 * participants in teams of track 2 int p: the total number of participants
 */
package com.javaimplant.codingproblems.ibm;

public class HackathonTracks {

	static int countTeams(int teamSize_1,int teamSize_2,int p) {
		int minT1 = p/teamSize_1;
		int rem1 = p% teamSize_1;
		while(minT1 >= 0) {
			if(rem1%teamSize_2==0) {
				break;
			}
			minT1--;
			rem1 += teamSize_1;
		}
		
		int minT2 = p/teamSize_2;
		int rem2 = p% teamSize_2;
		while(minT2 >= 0) {
			if(rem2%teamSize_1==0) {
				break;
			}
			minT2--;
			rem2 += teamSize_2;
		}
		
		if(minT1<0 && minT2<0) {
			return -1;
		} else if(minT1<0) {
			return minT2 + rem2/teamSize_1;
		} else if(minT2<0) {
			return minT1 + rem2/teamSize_2;
		}else {
			return Math.min(minT1 + rem1/teamSize_2,minT2+rem2/teamSize_1);
		}
	}
	
	public static void main(String args[]) {
		int teamSize_1 = 3;
		int teamSize_2 = 4;
		int p = 6;
		
		int result = countTeams(teamSize_1,teamSize_2,p);
		
		if(result == -1) {
			System.out.println("Cannot form teams with the given participant count");
		} else {
			System.out.println("Minimum Number of teams:"+result);
		}
		
		teamSize_1 = 3;
		teamSize_2 = 4;
		p = 7;
		
		result = countTeams(teamSize_1,teamSize_2,p);
		
		if(result == -1) {
			System.out.println("Cannot form teams with the given participant count");
		} else {
			System.out.println("Minimum Number of teams:"+result);
		}
	}
}
