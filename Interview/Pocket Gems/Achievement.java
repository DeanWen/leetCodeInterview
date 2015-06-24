import java.util.*;

/*
 * Achievement System Design, requirement: 
 * (1)no new codes should be added when adding similar achievements/requirements
 * (原来有个achievement 叫reachLVL2 , 新加一个reachLVL5 , 不能新写一个类
 * (2) new codes can be added with minimum amount when adding brand new achivements
 * (新加一个connectOnFB achievement , 类的借口不能被破坏) 
 * */

interface Requirement {
    public boolean isSatisfied(Player player);
}
interface Reward {
    public boolean isGiven(Player player);
}
class Player {
	int level;
}
class ReachLvlReq implements Requirement {
	int level;
	ReachLvlReq (int level) {
		this.level = level;
	}
	
	@Override
	public boolean isSatisfied(Player player) {
		return player.level >= this.level;
	}
}

class Achievement {
	List<Requirement> rqlist;
	List<Reward> rwlist;
	
	public Achievement () {
		this.rqlist = null;
		this.rwlist = null;
	}
	
	public boolean isQualify(Player player) {
		for (Requirement r : rqlist) {
			if (!r.isSatisfied(player)) {
				return false;
			}
		}
		return true;
	} 
}
