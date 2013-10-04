package eu.stiekema.jeroen.tiptel.factory;

import eu.stiekema.jeroen.tiptel.state.AbstractResourceState;
import eu.stiekema.jeroen.tiptel.state.AnnouncementResourceState;
import eu.stiekema.jeroen.tiptel.state.ChargeResourceState;
import eu.stiekema.jeroen.tiptel.state.FilterResourceState;
import eu.stiekema.jeroen.tiptel.state.InformationResourceState;
import eu.stiekema.jeroen.tiptel.state.MemoryLocationNrState;
import eu.stiekema.jeroen.tiptel.state.NameResourceState;
import eu.stiekema.jeroen.tiptel.state.PhoneNumberResourceState;
import eu.stiekema.jeroen.tiptel.state.ProgramOrderNrState;
import eu.stiekema.jeroen.tiptel.state.ResourceState;
import eu.stiekema.jeroen.tiptel.state.SoundResourceState;

/**
 * @author Jeroen Stiekema
 */
public class ResourceStateFactory {
    public static ResourceState createResourceState() {
        AbstractResourceState programOrderNrState = new ProgramOrderNrState();

        AbstractResourceState memoryLocationNrState = new MemoryLocationNrState();
        programOrderNrState.setNext(memoryLocationNrState);

        AbstractResourceState nameState = new NameResourceState();
        memoryLocationNrState.setNext(nameState);

        AbstractResourceState phoneNumberResourceState = new PhoneNumberResourceState();
        nameState.setNext(phoneNumberResourceState);

        AbstractResourceState informationResourceState = new InformationResourceState();
        phoneNumberResourceState.setNext(informationResourceState);

        AbstractResourceState soundResourceState = new SoundResourceState();
        informationResourceState.setNext(soundResourceState);

        AbstractResourceState filterResourceState = new FilterResourceState();
        soundResourceState.setNext(filterResourceState);

        AbstractResourceState chargeResourceState = new ChargeResourceState();
        filterResourceState.setNext(chargeResourceState);

        AbstractResourceState announcementResourceState = new AnnouncementResourceState();
        chargeResourceState.setNext(announcementResourceState);

        announcementResourceState.setNext(programOrderNrState);

        return programOrderNrState;
    }
}
