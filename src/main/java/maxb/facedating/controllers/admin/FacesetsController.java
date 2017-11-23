package maxb.facedating.controllers.admin;

import maxb.facedating.domain.rest.FacePlusResult;
import maxb.facedating.domain.rest.FacesetDetails;
import maxb.facedating.domain.rest.FacesetInfo;
import maxb.facedating.faceplus.FacePlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * Created by MaxB on 10/11/2017.
 */
@Controller
@RequestMapping("/admin/faceset")
public class FacesetsController {


    @Autowired
    FacePlusService facePlusService;

    @RequestMapping(method = RequestMethod.GET)
    public String getFacesetsList(ModelMap model) throws IOException {

        FacePlusResult facePlusResult = facePlusService.getFacesetList(1);
        FacesetInfo[] facesets = facePlusResult.getFacesets();

        model.addAttribute("facesets", facesets);

        model.addAttribute("urlAdd", "/admin/faceset/add");
        model.addAttribute("addTitle", "Add Faceset");

        return "admin/facesets_list";
    }

    @RequestMapping(value = "/{facesetToken}", method = RequestMethod.GET)
    public String getFacesetDetails(@PathVariable String facesetToken, ModelMap model) throws IOException {

        FacesetDetails facesetDetails = facePlusService.getFacesetDetails(facesetToken,1);
        String[] faceTokens = facesetDetails.getFaceTokens();

        model.addAttribute("facesetDetails", facesetDetails);
        model.addAttribute("faceTokens", faceTokens);

        return "admin/facesets_details";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addFaceset(ModelMap model) throws IOException {

        model.addAttribute("facesetDetails", new FacesetDetails());
        model.addAttribute("isUpdating", false);

        return "admin/facesets_form";
    }

    @RequestMapping(value = "/{facesetToken}/update", method = RequestMethod.GET)
    public String updateFaceset(@PathVariable String facesetToken, ModelMap model) throws IOException {

        FacesetDetails facesetDetails = facePlusService.getFacesetDetails(facesetToken,1);

        model.addAttribute("facesetDetails", facesetDetails);
        model.addAttribute("isUpdating", true);

        return "admin/facesets_form";
    }



    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateFaceset(@ModelAttribute("facesetDetails") FacesetDetails facesetDetails,
                                BindingResult result, Model model,
                                final RedirectAttributes redirectAttributes) throws IOException {

        if (result.hasErrors()) {
            //populateDefaultModel(model);
            return "admin/facesets_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(facesetDetails.getFacesetToken() == null){

                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
                FacePlusResult facePlusResult =
                        facePlusService.createFaceset(facesetDetails.getDisplayName(), facesetDetails.getUserData(), "");

                return "redirect:/admin/faceset/" + facePlusResult.getFacesetToken();

            }else{

                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
                FacePlusResult facePlusResult = facePlusService.updateFaceset(facesetDetails.getFacesetToken(),
                        facesetDetails.getDisplayName(), facesetDetails.getUserData(), "");

                return "redirect:/admin/faceset/" + facePlusResult.getFacesetToken();
            }



        }

    }

    @RequestMapping(value = "/{facesetToken}/delete", method = RequestMethod.GET)
    public String deleteFaceset(@PathVariable String facesetToken, RedirectAttributes redirectAttributes) throws IOException {


        facePlusService.deleteFaceset(facesetToken);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Faceset is deleted!");

        return "redirect:/admin/faceset";

    }
}
