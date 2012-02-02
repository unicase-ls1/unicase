package humandiagramgef;

import humanbodymodel.Human;
import humanbodymodel.HumanContainer;
import humanbodymodel.HumanLink;
import humanbodymodel.HumanbodymodelFactory;

import java.util.HashMap;

import org.eclipse.ui.PlatformUI;

public class HumanBodyModelUtils {
	
	private HashMap<HumanBodyEnum, Human> humanParts;
	private HumanbodymodelFactory factory = HumanbodymodelFactory.eINSTANCE;
	private HumanContainer container;
	
	
	public HumanBodyModelUtils () {
		humanParts = new HashMap<HumanBodyEnum, Human>();
		container = factory.createHumanContainer();
		createModel();
	}
	
	
	public void createModel() {
		Human head = createHuman(HumanBodyEnum.Head);
		Human shoulderCenter = createHuman(HumanBodyEnum.Shoulder_Center);
		Human shoulderLeft = createHuman(HumanBodyEnum.Shoulder_Left);
		Human shoulderRight = createHuman(HumanBodyEnum.Shoulder_Right);
		Human elbowLeft = createHuman(HumanBodyEnum.Elbow_Left);
		Human elbowRight = createHuman(HumanBodyEnum.Elbow_Right);
		Human wristLeft = createHuman(HumanBodyEnum.Wrist_Left);
		Human wristRight = createHuman(HumanBodyEnum.Wrist_Right);
		Human handLeft = createHuman(HumanBodyEnum.Hand_Left);
		Human handRight = createHuman(HumanBodyEnum.Hand_Right);
		
		handLeft.setColor_r(255);
		handLeft.setColor_g(0);
		handLeft.setColor_b(0);
		handRight.setColor_r(255);
		
		head.setColor_b(255);
		
		Human spine = createHuman(HumanBodyEnum.Spine);
		Human hipCenter = createHuman(HumanBodyEnum.Hip_Center);
		Human hipLeft = createHuman(HumanBodyEnum.Hip_Left);
		Human hipRight = createHuman(HumanBodyEnum.Hip_Right);
		Human kneeLeft = createHuman(HumanBodyEnum.Knee_Left);
		Human kneeRight = createHuman(HumanBodyEnum.Knee_Right);
		Human ankleLeft = createHuman(HumanBodyEnum.Ankle_Left);
		Human ankleRight = createHuman(HumanBodyEnum.Ankle_Right);
		Human footLeft = createHuman(HumanBodyEnum.Foot_Left);
		Human footRight = createHuman(HumanBodyEnum.Foot_Right);
		
		footLeft.setColor_g(255);
		footRight.setColor_g(255);
		
		createLink(head, shoulderCenter);
		createLink(shoulderCenter, shoulderLeft);
		createLink(shoulderCenter, shoulderRight);
		createLink(shoulderLeft, elbowLeft);
		createLink(shoulderRight, elbowRight);
		createLink(elbowLeft, wristLeft);
		createLink(elbowRight, wristRight);
		createLink(wristLeft, handLeft);
		createLink(wristRight, handRight);
		
		createLink(shoulderCenter,spine);
		createLink(spine, hipCenter);
		createLink(hipCenter, hipLeft);
		createLink(hipCenter, hipRight);
		createLink(hipLeft, kneeLeft);
		createLink(hipRight, kneeRight);
		createLink(kneeLeft, ankleLeft);
		createLink(kneeRight, ankleRight);
		createLink(ankleLeft, footLeft);
		createLink(ankleRight, footRight);
		
	}
	
	public void changeCoordinates(HumanBodyEnum type, float x, float y, float z) {
		if (type != null) {
			Human part = humanParts.get(type);
			part.setX(x);
			part.setY(y);
			part.setZ(z);
		}
		
	}
	
	public HumanContainer getHumanContainer() {
		return this.container;
	}
	
	public void init() {
		//humanParts = new HashMap<HumanBodyEnum, Human>();
		//container = factory.createHumanContainer();
		//createModel();
		((HumanDiagramGraphicalEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()).setContent(container);
	}
	
	private Human createHuman(HumanBodyEnum type) {
		Human humanPart = factory.createHuman();
		humanPart.setName(type.toString());
		container.getElements().add(humanPart);
		humanParts.put(type, humanPart); 
		return humanPart;
	}
	
	private void createLink(Human source, Human target) {
		HumanLink link = factory.createHumanLink();
		link.setSource(source);
		link.setTarget(target);
		
		source.getOutgoingLinks().add(link);
		target.getIncomingLinks().add(link);
		
		container.getLinks().add(link);
	}
}
