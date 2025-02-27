/**************************************************************************
**  OMTools
**  A software package for processing and analyzing optical mapping data
**  
**  Version 1.4 -- March 10, 2018
**  
**  Copyright (C) 2018 by Alden Leung, Ting-Fung Chan, All rights reserved.
**  Contact:  alden.leung@gmail.com, tf.chan@cuhk.edu.hk
**  Organization:  School of Life Sciences, The Chinese University of Hong Kong,
**                 Shatin, NT, Hong Kong SAR
**  
**  This file is part of OMTools.
**  
**  OMTools is free software; you can redistribute it and/or 
**  modify it under the terms of the GNU General Public License 
**  as published by the Free Software Foundation; either version 
**  3 of the License, or (at your option) any later version.
**  
**  OMTools is distributed in the hope that it will be useful,
**  but WITHOUT ANY WARRANTY; without even the implied warranty of
**  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
**  GNU General Public License for more details.
**  
**  You should have received a copy of the GNU General Public 
**  License along with OMTools; if not, see 
**  <http://www.gnu.org/licenses/>.
**************************************************************************/


package aldenjava.opticalmapping.visualizer.vobject;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import aldenjava.opticalmapping.visualizer.ViewSetting;

public class VBlockSpace extends VSpace {
	public VBlockSpace(long reflength, long mollength) {
		super(reflength, mollength);
	}

	@Override
	public void autoSetSize() {
		this.setSize((int) (reflength / dnaRatio * ratio), (int) (ViewSetting.bodyHeight * ratio));
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setStroke(new BasicStroke((float) (ViewSetting.gapStrokeWidth * ratio)));
		g.setPaint(ViewSetting.gapStrokeColor);		
		// Drawing line
		double refSpaceWidth = (reflength / dnaRatio * ratio);
		if (refSpaceWidth > 0)
			g.draw(new Line2D.Double(0, this.getHeight() / 2.0, refSpaceWidth, this.getHeight() / 2.0));
	}

	@Override
	public String getType() {
		return "BlockSpace";
	}

}
