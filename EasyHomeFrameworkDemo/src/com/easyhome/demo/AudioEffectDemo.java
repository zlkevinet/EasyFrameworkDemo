/**
 * Copyright Baidu.Inc
 */
package com.easyhome.demo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.easyhome.framework.activity.BaseActivity;
import com.easyhome.framework.module.ModuleType;
import com.easyhome.framework.module.local.MediaEffectModule;

/**
 * 
 * @author zhoulu
 * @since 2012-11-30-上午11:21:51
 * @version 1.0
 */
public class AudioEffectDemo extends BaseActivity {

	private MediaEffectModule mediaEffectModule;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.audio_effect);
		mediaEffectModule = (MediaEffectModule) addSystemModule(ModuleType.MEDIA_EFFECT, null);
	}
	@Override
	public void onFirstLoadData() {
	}

	@Override
	public void onInitViews() {
		Button music = (Button) findViewById(R.id.button1);
		music.setOnClickListener(new View.OnClickListener() {
			MediaPlayer mediaPlayer;
			@Override
			public void onClick(View v) {
				if(mediaPlayer == null || !mediaPlayer.isPlaying()){
					mediaPlayer = MediaPlayer.create(AudioEffectDemo.this, R.raw.dingding);
					mediaPlayer.start();
					((Button)v).setText("CloseMusic");
				} else {
					mediaPlayer.stop();
					((Button)v).setText("OpenMusic");
				}
			}
		});
		Button effect = (Button) findViewById(R.id.button2);
		effect.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*
				 * TODO move to framework
				 */
//				Intent i = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
//				i.putExtra(AudioEffect.EXTRA_CONTENT_TYPE, AudioEffect.CONTENT_TYPE_MUSIC);
//				AudioEffectDemo.this.startActivityForResult(i, 0);
				
				mediaEffectModule.openGlobalEffect();
			}
		});
	}

}
