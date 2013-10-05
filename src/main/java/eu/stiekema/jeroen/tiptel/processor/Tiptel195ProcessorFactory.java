package eu.stiekema.jeroen.tiptel.processor;

/**
 * @author Jeroen Stiekema
 */

public class Tiptel195ProcessorFactory implements TiptelProcessorFactory {

    @Override
    public TiptelFieldProcessor createTiptelFieldProcessor() {
        AbstractTiptelFieldProcessor programOrderNrState = new ProgramOrderNrFieldProcessor();

        AbstractTiptelFieldProcessor memoryLocationNrState = new MemoryLocationNrProcessor();
        programOrderNrState.setNext(memoryLocationNrState);

        AbstractTiptelFieldProcessor nameState = new NameFieldProcessor();
        memoryLocationNrState.setNext(nameState);

        AbstractTiptelFieldProcessor phoneNumberResourceState = new PhoneNumberFieldProcessor();
        nameState.setNext(phoneNumberResourceState);

        AbstractTiptelFieldProcessor informationResourceState = new InformationFieldProcessor();
        phoneNumberResourceState.setNext(informationResourceState);

        AbstractTiptelFieldProcessor soundResourceState = new SoundFieldProcessor();
        informationResourceState.setNext(soundResourceState);

        AbstractTiptelFieldProcessor filterResourceState = new FilterFieldProcessor();
        soundResourceState.setNext(filterResourceState);

        AbstractTiptelFieldProcessor chargeResourceState = new ChargeFieldProcessor();
        filterResourceState.setNext(chargeResourceState);

        AbstractTiptelFieldProcessor announcementResourceState = new AnnouncementFieldProcessor();
        chargeResourceState.setNext(announcementResourceState);

        return programOrderNrState;
    }
}
