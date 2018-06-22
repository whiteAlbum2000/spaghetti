package RidingHood.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets 
{
	public static BufferedImage blueSky,candySky, nightSkyA, nightSkyB, greenTree, candyTree, nightTree, greenGround, candyGround, nightGround, nothing, player_quick_right, 
									player_quick_left,gbullet, gbulletEx, bullet, bulletEx, bullet2, bullet2Ex
	 							, bullet3, bullet3Ex, rbullet, rbulletEx, rbullet2, rbullet2Ex, rbullet3, rbullet3Ex, star, menuUse, mapUse, hp, lose, win
	 							, helpUse;
	public static BufferedImage[] player_stand_right, player_work_right, player_jump_right, player_general_right
									, player_generalwork_right, player_right_h, player_right_c, player_stand_left, player_work_left, player_jump_left, player_general_left,
									 player_generalwork_left, player_left_h, player_left_c, walkOnion, walkOnionLA, walkOnionRA
									, right_flyOnion, left_flyOnion, right_flyOnionA, left_flyOnionA, left_onionBoss, right_onionBoss
									, left_onionBossA, right_onionBossA, start, help, exit, green, candy, night, back, info, playAgain;
	public static Font font40, font30;
	
	public static void init()
	{
		blueSky = ImageLoader.LoadImage("/texture/blueSky.jpg");
		candySky = ImageLoader.LoadImage("/texture/candySky.jpg");
		nightSkyA = ImageLoader.LoadImage("/texture/nightSky1.jpg");
		nightSkyB = ImageLoader.LoadImage("/texture/nightSky2.jpg");
		greenTree = ImageLoader.LoadImage("/texture/greenTree1.png");
		candyTree = ImageLoader.LoadImage("/texture/candyTree.png");
		nightTree = ImageLoader.LoadImage("/texture/nightTree.png");
		greenGround = ImageLoader.LoadImage("/texture/greenGround.jpg");
		candyGround = ImageLoader.LoadImage("/texture/candyGround.jpg");
		nightGround = ImageLoader.LoadImage("/texture/nightGround.jpg");
		nothing = ImageLoader.LoadImage("/texture/nothing.png");
		
		gbullet = ImageLoader.LoadImage("/texture/gbullet.png");
		gbulletEx = ImageLoader.LoadImage("/texture/gbulletEx.png");
		
		
		bullet = ImageLoader.LoadImage("/texture/bullet.png");
		bulletEx = ImageLoader.LoadImage("/texture/bulletEx.png");
		
		bullet2 = ImageLoader.LoadImage("/texture/bullet2.png");
		bullet2Ex = ImageLoader.LoadImage("/texture/bullet2Ex.png");
		
		bullet3 = ImageLoader.LoadImage("/texture/bullet3.png");
		bullet3Ex = ImageLoader.LoadImage("/texture/bullet3Ex.png");
		
		rbullet = ImageLoader.LoadImage("/texture/rbullet.png");
		rbulletEx = ImageLoader.LoadImage("/texture/rbulletEx.png");
		
		rbullet2 = ImageLoader.LoadImage("/texture/rbullet2.png");
		rbullet2Ex = ImageLoader.LoadImage("/texture/rbullet2Ex.png");
		
		rbullet3 = ImageLoader.LoadImage("/texture/rbullet3.png");
		rbullet3Ex = ImageLoader.LoadImage("/texture/rbullet3Ex.png");
		
		star = ImageLoader.LoadImage("/texture/star.png");
		
		menuUse = ImageLoader.LoadImage("/texture/menuUse.jpg");
		mapUse = ImageLoader.LoadImage("/texture/mapuse.jpg");
		hp = ImageLoader.LoadImage("/texture/hp.png");
		lose = ImageLoader.LoadImage("/texture/lose.png");
		win = ImageLoader.LoadImage("/texture/win.png");
		helpUse = ImageLoader.LoadImage("/texture/helpUse.jpg");
		
		player_stand_right = new BufferedImage[4];
		player_work_right = new BufferedImage[4];
		player_jump_right = new BufferedImage[6];
		player_general_right = new BufferedImage[5];
		player_generalwork_right = new BufferedImage[5];
		player_right_h = new BufferedImage[3];
		player_right_c = new BufferedImage[6];
		walkOnion = new BufferedImage[2];
		walkOnionLA = new BufferedImage[4];
		walkOnionRA = new BufferedImage[7];
		right_flyOnion = new BufferedImage[4];
		left_flyOnion = new BufferedImage[4];
		right_flyOnionA = new BufferedImage[4];
		left_flyOnionA = new BufferedImage[4];
		left_onionBoss = new BufferedImage[2];
		right_onionBoss = new BufferedImage[2];
		left_onionBossA = new BufferedImage[11];
		right_onionBossA = new BufferedImage[11];
		start = new BufferedImage[2];
		exit = new BufferedImage[2];
		help = new BufferedImage[2];
		green = new BufferedImage[2];
		candy = new BufferedImage[2];
		night = new BufferedImage[2];
		back = new BufferedImage[2];
		info = new BufferedImage[2];
		playAgain = new BufferedImage[2];

		player_stand_left = new BufferedImage[4];
		player_work_left = new BufferedImage[4];
		player_jump_left = new BufferedImage[6];
		player_general_left = new BufferedImage[5];
		player_generalwork_left = new BufferedImage[5];
		player_left_h = new BufferedImage[3];
		player_left_c = new BufferedImage[6];
		
		player_stand_right[0] = ImageLoader.LoadImage("/texture/RidingHood_stand1.png");
		player_stand_right[1] = ImageLoader.LoadImage("/texture/RidingHood_rightStand3.png");
		player_stand_right[2] = ImageLoader.LoadImage("/texture/RidingHood_rightStand2.png");
		player_stand_right[3] = player_stand_right[1];
		
		player_work_right[0] = ImageLoader.LoadImage("/texture/RidingHood_stand1.png");
		player_work_right[1] = ImageLoader.LoadImage("/texture/RidingHood_rightWorking1.png");
		player_work_right[2] = ImageLoader.LoadImage("/texture/RidingHood_rightWorking2.png");
		player_work_right[3] = player_work_right[1];
		
		player_jump_right[0] = ImageLoader.LoadImage("/texture/RidingHood_rightJump1.png");
		player_jump_right[1] = ImageLoader.LoadImage("/texture/RidingHood_rightJump2.png");
		player_jump_right[2] = ImageLoader.LoadImage("/texture/RidingHood_rightJump3.png");
		player_jump_right[3] = player_jump_right[2];
		player_jump_right[4] = player_jump_right[1];
		player_jump_right[5] = player_jump_right[0];
		
		player_general_right[0] = ImageLoader.LoadImage("/texture/right_Gattack.png");
		player_general_right[1] = ImageLoader.LoadImage("/texture/right_Gattack2.png");
		player_general_right[2] = ImageLoader.LoadImage("/texture/right_Gattack3.png");
		player_general_right[3] = ImageLoader.LoadImage("/texture/right_Gattack4.png");
		player_general_right[4] = ImageLoader.LoadImage("/texture/right_Gattack5.png");
		
		player_generalwork_right[0] = player_general_right[0];
		player_generalwork_right[1] = ImageLoader.LoadImage("/texture/right_Gattack2(work).png");
		player_generalwork_right[2] = ImageLoader.LoadImage("/texture/right_Gattack3(work).png");
		player_generalwork_right[3] = ImageLoader.LoadImage("/texture/right_Gattack4(work).png");
		player_generalwork_right[4] = player_general_right[4];
		
		player_stand_left[0] = ImageLoader.LoadImage("/texture/RidingHood_stand2.png");
		player_stand_left[1] = ImageLoader.LoadImage("/texture/RidingHood_leftStand3.png");
		player_stand_left[2] = ImageLoader.LoadImage("/texture/RidingHood_leftStand2.png");
		player_stand_left[3] = player_stand_left[1];
		
		player_work_left[0] = ImageLoader.LoadImage("/texture/RidingHood_stand1.png");
		player_work_left[1] = ImageLoader.LoadImage("/texture/RidingHood_leftWorking1.png");
		player_work_left[2] = ImageLoader.LoadImage("/texture/RidingHood_leftWorking2.png");
		player_work_left[3] = player_work_left[1];
		
		player_jump_left[0] = ImageLoader.LoadImage("/texture/RidingHood_leftJump1.png");
		player_jump_left[1] = ImageLoader.LoadImage("/texture/RidingHood_leftJump2.png");
		player_jump_left[2] = ImageLoader.LoadImage("/texture/RidingHood_leftJump3.png");
		player_jump_left[3] = player_jump_left[2];
		player_jump_left[4] = player_jump_left[1];
		player_jump_left[5] = player_jump_left[0];
		
		player_general_left[0] = ImageLoader.LoadImage("/texture/left_Gattack.png");
		player_general_left[1] = ImageLoader.LoadImage("/texture/left_Gattack2.png");
		player_general_left[2] = ImageLoader.LoadImage("/texture/left_Gattack3.png");
		player_general_left[3] = ImageLoader.LoadImage("/texture/left_Gattack4.png");
		player_general_left[4] = ImageLoader.LoadImage("/texture/left_Gattack5.png");
		
		player_generalwork_left[0] = player_general_left[0];
		player_generalwork_left[1] = ImageLoader.LoadImage("/texture/left_Gattack2(work).png");
		player_generalwork_left[2] = ImageLoader.LoadImage("/texture/left_Gattack3(work).png");
		player_generalwork_left[3] = ImageLoader.LoadImage("/texture/left_Gattack4(work).png");
		player_generalwork_left[4] = player_general_left[4];
		
		player_quick_left = ImageLoader.LoadImage("/texture/left_Qattack.png");
		
		player_left_h[0] = ImageLoader.LoadImage("/texture/left_Hattack.png");
		player_left_h[1] = ImageLoader.LoadImage("/texture/left_Hattack2.png");
		player_left_h[2] = ImageLoader.LoadImage("/texture/left_Hattack3.png");
		
		player_left_c[0] = ImageLoader.LoadImage("/texture/left_C1.png");
		player_left_c[1] = ImageLoader.LoadImage("/texture/left_C2.png");
		player_left_c[2] = ImageLoader.LoadImage("/texture/left_C3.png");
		player_left_c[3] = ImageLoader.LoadImage("/texture/left_C4.png");
		player_left_c[4] = ImageLoader.LoadImage("/texture/left_C5.png");
		player_left_c[5] = player_left_c[0];
		
		player_quick_right = ImageLoader.LoadImage("/texture/right_Qattack.png");
		
		player_right_h[0] = ImageLoader.LoadImage("/texture/right_Hattack.png");
		player_right_h[1] = ImageLoader.LoadImage("/texture/right_Hattack2.png");
		player_right_h[2] = ImageLoader.LoadImage("/texture/right_Hattack3.png");
		
		player_right_c[0] = ImageLoader.LoadImage("/texture/right_C1.png");
		player_right_c[1] = ImageLoader.LoadImage("/texture/right_C2.png");
		player_right_c[2] = ImageLoader.LoadImage("/texture/right_C3.png");
		player_right_c[3] = ImageLoader.LoadImage("/texture/right_C4.png");
		player_right_c[4] = ImageLoader.LoadImage("/texture/right_C5.png");
		player_right_c[5] = player_right_c[0];
		
		walkOnion[0] = ImageLoader.LoadImage("/texture/right_walkOnion1.png");
		walkOnion[1] = ImageLoader.LoadImage("/texture/left_walkOnion1.png");
		
		walkOnionLA[0] = walkOnion[1];
		walkOnionLA[1] = ImageLoader.LoadImage("/texture/left_walkOnion2.png");
		walkOnionLA[2] = ImageLoader.LoadImage("/texture/left_walkOnion3.png");
		walkOnionLA[3] = walkOnionLA[1];
		
		walkOnionRA[0] = walkOnion[0];
		walkOnionRA[1] = ImageLoader.LoadImage("/texture/right_walkOnion2.png");
		walkOnionRA[2] = ImageLoader.LoadImage("/texture/right_walkOnion3.png");
		walkOnionRA[3] = walkOnionRA[1];
		
		right_flyOnion[0] = walkOnion[0];
		right_flyOnion[1] = ImageLoader.LoadImage("/texture/right_flyOnion1.png");
		right_flyOnion[2] = ImageLoader.LoadImage("/texture/right_flyOnion2.png");
		right_flyOnion[3] = ImageLoader.LoadImage("/texture/right_flyOnion3.png");
		
		left_flyOnion[0] = walkOnion[1];
		left_flyOnion[1] = ImageLoader.LoadImage("/texture/left_flyOnion1.png");
		left_flyOnion[2] = ImageLoader.LoadImage("/texture/left_flyOnion2.png");
		left_flyOnion[3] = ImageLoader.LoadImage("/texture/left_flyOnion3.png");
		
		right_flyOnionA[0] = walkOnion[0];
		right_flyOnionA[1] = ImageLoader.LoadImage("/texture/right_flyOnionA1.png");
		right_flyOnionA[2] = ImageLoader.LoadImage("/texture/right_flyOnionA2.png");
		right_flyOnionA[3] = ImageLoader.LoadImage("/texture/right_flyOnionA3.png");
		
		left_flyOnionA[0] = walkOnion[1];
		left_flyOnionA[1] = ImageLoader.LoadImage("/texture/left_flyOnionA1.png");
		left_flyOnionA[2] = ImageLoader.LoadImage("/texture/left_flyOnionA2.png");
		left_flyOnionA[3] = ImageLoader.LoadImage("/texture/left_flyOnionA3.png");
		
		left_onionBoss[0] = ImageLoader.LoadImage("/texture/left_boss1.png");
		left_onionBoss[1] = ImageLoader.LoadImage("/texture/left_boss2.png");
		
		right_onionBoss[0] = ImageLoader.LoadImage("/texture/right_boss1.png");
		right_onionBoss[1] = ImageLoader.LoadImage("/texture/right_boss2.png");
		
		left_onionBossA[0] = ImageLoader.LoadImage("/texture/left_bossA1.png");
		left_onionBossA[1] = ImageLoader.LoadImage("/texture/left_bossA2.png");
		left_onionBossA[2] = ImageLoader.LoadImage("/texture/left_bossA3.png");
		left_onionBossA[3] = ImageLoader.LoadImage("/texture/left_bossA4.png");
		left_onionBossA[4] = ImageLoader.LoadImage("/texture/left_bossA5.png");
		left_onionBossA[5] = ImageLoader.LoadImage("/texture/left_bossA6.png");
		left_onionBossA[6] = ImageLoader.LoadImage("/texture/left_bossA7.png");
		left_onionBossA[7] = ImageLoader.LoadImage("/texture/left_bossA8.png");
		left_onionBossA[8] = ImageLoader.LoadImage("/texture/left_bossA9.png");
		left_onionBossA[9] = ImageLoader.LoadImage("/texture/left_bossA10.png");
		left_onionBossA[10] = ImageLoader.LoadImage("/texture/left_bossA11.png");
		
		right_onionBossA[0] = ImageLoader.LoadImage("/texture/right_bossA1.png");
		right_onionBossA[1] = ImageLoader.LoadImage("/texture/right_bossA2.png");
		right_onionBossA[2] = ImageLoader.LoadImage("/texture/right_bossA3.png");
		right_onionBossA[3] = ImageLoader.LoadImage("/texture/right_bossA4.png");
		right_onionBossA[4] = ImageLoader.LoadImage("/texture/right_bossA5.png");
		right_onionBossA[5] = ImageLoader.LoadImage("/texture/right_bossA6.png");
		right_onionBossA[6] = ImageLoader.LoadImage("/texture/right_bossA7.png");
		right_onionBossA[7] = ImageLoader.LoadImage("/texture/right_bossA8.png");
		right_onionBossA[8] = ImageLoader.LoadImage("/texture/right_bossA9.png");
		right_onionBossA[9] = ImageLoader.LoadImage("/texture/right_bossA10.png");
		right_onionBossA[10] = ImageLoader.LoadImage("/texture/right_bossA11.png");
		
		start[0] = ImageLoader.LoadImage("/texture/start1.png");
		start[1] = ImageLoader.LoadImage("/texture/start2.png");
		
		exit[0] = ImageLoader.LoadImage("/texture/exit1.png");
		exit[1] = ImageLoader.LoadImage("/texture/exit2.png");
		
		help[0] = ImageLoader.LoadImage("/texture/help1.png");
		help[1] = ImageLoader.LoadImage("/texture/help2.png");
		
		green[0]= ImageLoader.LoadImage("/texture/green.png");
		green[1] = ImageLoader.LoadImage("/texture/green2.png");
		
		candy[0]= ImageLoader.LoadImage("/texture/candy.png");
		candy[1]= ImageLoader.LoadImage("/texture/candy2.png");
		
		night[0]= ImageLoader.LoadImage("/texture/night.png");
		night[1]= ImageLoader.LoadImage("/texture/night2.png");
		
		back[0] = ImageLoader.LoadImage("/texture/back1.png");
		back[1] = ImageLoader.LoadImage("/texture/back2.png");
		
		info[0] = ImageLoader.LoadImage("/texture/info1.png");
		info[1] = ImageLoader.LoadImage("/texture/info2.png");
		
		playAgain[0] = ImageLoader.LoadImage("/texture/playAgain1.png");
		playAgain[1] = ImageLoader.LoadImage("/texture/playAgain2.png");
		
		font40 = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
		font30 = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
	}
}
