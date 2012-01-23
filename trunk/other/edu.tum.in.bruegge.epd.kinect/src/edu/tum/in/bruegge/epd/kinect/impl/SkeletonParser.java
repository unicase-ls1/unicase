package edu.tum.in.bruegge.epd.kinect.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import humandiagramgef.HumanBodyEnum;
import humandiagramgef.HumanBodyModelUtils;

public class SkeletonParser {
	
	private HumanBodyModelUtils humanBodyModel;


	public SkeletonParser(HumanBodyModelUtils humanBodyHandler) {
		this.humanBodyModel = humanBodyHandler;
	}
	
	public void parseSkeleton(Document doc) {
		NodeList skeletons = doc.getElementsByTagName("skeletonData");
		for (int i = 0; i < skeletons.getLength(); i++) {
			Node skeleton = skeletons.item(i);
			NodeList skeletonData = skeleton.getChildNodes();
			
			for (int j = 0; j < skeletonData.getLength(); j++) {
				Node data = skeletonData.item(j);
				
				if (data.getNodeName().equals("joint")) {
					Joint joint = parseJoint(data);
					updateModel(joint);
				}
			}
		}
	}

	private Joint parseJoint(Node jointNode) {
		Joint joint = new Joint();
		
		NodeList data = jointNode.getChildNodes();
		for (int k = 0; k < data.getLength(); k++) {
			Node jointData = data.item(k);
			
			if (jointData.getNodeName().equals("jointId")) {
				String jointId = jointData.getTextContent();
				joint.part = getHumanPart(jointId);
			} else if (jointData.getNodeName().equals("positionX")) {
				String posX = jointData.getTextContent().replace(',', '.');
				joint.positionX = Float.parseFloat(posX);
			} else if (jointData.getNodeName().equals("positionY")) {
				String posY = jointData.getTextContent().replace(',', '.');
				joint.positionY = Float.parseFloat(posY);
			} else if (jointData.getNodeName().equals("positionZ")) {
				String posZ = jointData.getTextContent().replace(',', '.');
				joint.positionZ = Float.parseFloat(posZ);
			}
		}
		
		return joint;
	}
	
	private void updateModel(Joint joint) {
		this.humanBodyModel.changeCoordinates(joint.part, joint.positionX, joint.positionY, joint.positionZ);
	}
	
	private class Joint {
		private float positionX;
		private float positionY;
		private float positionZ;
		private HumanBodyEnum part;
	}
	
	
	private static HumanBodyEnum getHumanPart(String jointId) {
		// TODO Use proper names in XML
		// return HumanBodyEnum.valueOf(jointId);
		if (jointId.equals("Head")) {
			return HumanBodyEnum.Head;
		} else if (jointId.equals("HipCenter")) {
			return HumanBodyEnum.Hip_Center;
		} else if (jointId.equals("Spine")) {
			return HumanBodyEnum.Spine;
		}  else if (jointId.equals("ShoulderCenter")) {
			return HumanBodyEnum.Shoulder_Center;
		} else if (jointId.equals("ShoulderLeft")) {
			return HumanBodyEnum.Shoulder_Left;
		} else if (jointId.equals("ElbowLeft")) {
			return HumanBodyEnum.Elbow_Left;
		} else if (jointId.equals("WristLeft")) {
			return HumanBodyEnum.Wrist_Left;
		} else if (jointId.equals("HandLeft")) {
			return HumanBodyEnum.Hand_Left;
		} else if (jointId.equals("ShoulderRight")) {
			return HumanBodyEnum.Shoulder_Right;
		} else if (jointId.equals("ElbowRight")) {
			return HumanBodyEnum.Elbow_Right;
		} else if (jointId.equals("WristRight")) {
			return HumanBodyEnum.Wrist_Right;
		} else if (jointId.equals("HandRight")) {
			return HumanBodyEnum.Hand_Right;
		} else if (jointId.equals("HipLeft")) {
			return HumanBodyEnum.Hip_Left;
		} else if (jointId.equals("KneeLeft")) {
			return HumanBodyEnum.Knee_Left;
		} else if (jointId.equals("AnkleLeft")) {
			return HumanBodyEnum.Ankle_Left;
		} else if (jointId.equals("FootLeft")) {
			return HumanBodyEnum.Foot_Left;
		} else if (jointId.equals("HipRight")) {
			return HumanBodyEnum.Hip_Right;
		} else if (jointId.equals("KneeRight")) {
			return HumanBodyEnum.Knee_Right;
		} else if (jointId.equals("AnkleRight")) {
			return HumanBodyEnum.Ankle_Right;
		} else if (jointId.equals("FootRight")) {
			return HumanBodyEnum.Foot_Right;
		}
		
		// TODO Throw proper Exception here
		return null;
	}

}
